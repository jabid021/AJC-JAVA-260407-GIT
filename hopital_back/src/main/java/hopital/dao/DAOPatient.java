package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hopital.model.Patient;

public class DAOPatient implements IDAOPatient{

	@Override
	public Patient findById(Integer id) {
		Patient patient = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from patient where id = ?");
			requete.setInt(1, id);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				patient = new Patient(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		List<Patient> patients = new ArrayList();
		Patient patient = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from patient");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				patient = new Patient(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
				patients.add(patient);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public void insert(Patient patient) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("INSERT INTO patient (id,nom,prenom) VALUES (?,?,?)");
			requete.setInt(1,patient.getId());
			requete.setString(2,patient.getNom());
			requete.setString(3,patient.getPrenom());
			
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void update(Patient patient) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("UPDATE patient set nom=?,prenom=? where id=?");
			requete.setString(1,patient.getNom());
			requete.setString(2,patient.getPrenom());
			requete.setInt(3,patient.getId());
			
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void deleteById(Integer id) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("DELETE FROM patient where id=?");
			requete.setInt(1,id);

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

}
