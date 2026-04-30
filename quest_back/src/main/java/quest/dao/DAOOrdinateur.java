package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quest.model.Ordinateur;
import quest.model.Stagiaire;

public class DAOOrdinateur implements IDAO<Ordinateur,Integer> {

	@Override
	public Ordinateur findById(Integer numero) {
		DAOPersonne daoPersonne = new DAOPersonne();
		Ordinateur ordinateur = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from ordinateur where numero = ?");
			requete.setInt(1, numero);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Stagiaire utilisateur = (Stagiaire) daoPersonne.findById(rs.getInt("utilisateur"));
				ordinateur = new Ordinateur(rs.getInt("numero"),rs.getString("marque"),rs.getInt("ram"),utilisateur);

			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		DAOPersonne daoPersonne = new DAOPersonne();
		List<Ordinateur> ordinateurs = new ArrayList();
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from ordinateur");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Stagiaire utilisateur = (Stagiaire) daoPersonne.findById(rs.getInt("utilisateur"));
				Ordinateur ordinateur = new Ordinateur(rs.getInt("numero"),rs.getString("marque"),rs.getInt("ram"),utilisateur);
				ordinateurs.add(ordinateur);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordinateurs;
	}

	@Override
	public void insert(Ordinateur ordinateur) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("INSERT INTO ordinateur (marque,ram,utilisateur) VALUES (?,?,?)");
			requete.setString(1,ordinateur.getMarque());
			requete.setInt(2,ordinateur.getRam());
			if(ordinateur.getUtilisateur()==null) 
			{
				requete.setObject(3, null);
			}
			else 
			{
				requete.setInt(3, ordinateur.getUtilisateur().getId());
			}
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	
	}

	@Override
	public void update(Ordinateur ordinateur) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("update ordinateur set marque=?,ram=?,utilisateur=? where numero=?");
			requete.setString(1,ordinateur.getMarque());
			requete.setInt(2,ordinateur.getRam());
			if(ordinateur.getUtilisateur()==null) 
			{
				requete.setObject(3, null);
			}
			else 
			{
				requete.setInt(3, ordinateur.getUtilisateur().getId());
			}
			requete.setInt(4, ordinateur.getNumero());
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	
	}

	@Override
	public void delete(Integer numero) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("DELETE FROM ordinateur where numero=?");
			requete.setInt(1,numero);

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}


}
