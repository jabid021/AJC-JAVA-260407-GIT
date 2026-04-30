package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hopital.context.Singleton;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Visite;

public class DAOVisite implements IDAOVisite{

	@Override
	public Visite findById(Integer id) {
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		IDAOCompte daoCompte =  Singleton.getInstance().getDaoCompte();
		
		
		Visite visite = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from visite where numero = ?");
			requete.setInt(1, id);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,LocalDate.parse(rs.getString("date_visite")),rs.getDouble("prix"),rs.getInt("salle"));
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		IDAOCompte daoCompte =  Singleton.getInstance().getDaoCompte();
		
		List<Visite> visites = new ArrayList();
		Visite visite = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from visite");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,LocalDate.parse(rs.getString("date_visite")),rs.getDouble("prix"),rs.getInt("salle"));
			
				visites.add(visite);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}

	@Override
	public void insert(Visite visite) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("INSERT INTO visite (id_patient,id_medecin,prix,date_visite,salle) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			requete.setInt(1, visite.getPatient().getId());
			requete.setInt(2, visite.getMedecin().getId());
			requete.setDouble(3, visite.getPrix());
			requete.setString(4, visite.getDateVisite().toString());
			requete.setInt(5, visite.getSalle());
			
			requete.executeUpdate();
			
			ResultSet rs = requete.getGeneratedKeys();
			if(rs.next()) 
			{
				visite.setNumero(rs.getInt(1));
			}

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void update(Visite visite) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("UPDATE visite set id_patient=?,id_medecin=?,prix=?,date_visite=?,salle=? where numero=?");
			
			requete.setInt(1, visite.getPatient().getId());
			requete.setInt(2, visite.getMedecin().getId());
			requete.setDouble(3, visite.getPrix());
			requete.setString(4, visite.getDateVisite().toString());
			requete.setInt(5, visite.getSalle());
			requete.setInt(6, visite.getNumero());
			
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void deleteById(Integer id) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("DELETE FROM visite where numero=?");
			requete.setInt(1,id);

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}
	

	public void setIdPatientNull(Integer idPatient) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("UPDATE visite set id_patient=null where id_patient = ?");
			requete.setInt(1,idPatient);

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	
	public List<Visite> findByPatientId(Integer idPatient) {
		IDAOPatient daoPatient =  Singleton.getInstance().getDaoPatient();
		IDAOCompte daoCompte =  Singleton.getInstance().getDaoCompte();
		
		List<Visite> visites = new ArrayList();
		Visite visite = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from visite where id_patient=?");
			requete.setInt(1, idPatient);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,LocalDate.parse(rs.getString("date_visite")),rs.getDouble("prix"),rs.getInt("salle"));
			
				visites.add(visite);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}
	
	
	public List<Visite> findByMedecinIdAndDateVisiteBetween(Integer idMedecin,LocalDate debut, LocalDate fin) {
		IDAOPatient daoPatient =  Singleton.getInstance().getDaoPatient();
		IDAOCompte daoCompte =  Singleton.getInstance().getDaoCompte();
		
		List<Visite> visites = new ArrayList();
		Visite visite = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from visite where id_medecin=? and date_visite between ? and ?");
			requete.setInt(1, idMedecin);
			requete.setString(2,debut.toString());
			requete.setString(3, fin.toString());
			
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,LocalDate.parse(rs.getString("date_visite")),rs.getDouble("prix"),rs.getInt("salle"));
			
				visites.add(visite);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}
}
