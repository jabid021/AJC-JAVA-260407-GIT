package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import quest.model.Filiere;
import quest.model.Salle;

public class DAOFiliere implements IDAO<Filiere,Integer> {

	
	@Override
	public Filiere findById(Integer id) {
		DAOSalle daoSalle = new DAOSalle();
		Filiere filiere = null;
		try 
		{
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete = conn.prepareStatement("SELECT * from filiere where id=?");
			requete.setInt(1,id);
			ResultSet rs = requete.executeQuery();
			
			while(rs.next()) 
			{
				Salle salle = daoSalle.findById(rs.getInt("salle"));
				filiere = new Filiere(rs.getInt("id"),rs.getString("libelle"),LocalDate.parse(rs.getString("debut")),LocalDate.parse(rs.getString("fin")),salle);
			}
			
			rs.close();
			requete.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return filiere;
	}

	@Override
	public List<Filiere> findAll() {
		DAOSalle daoSalle = new DAOSalle();
		List<Filiere> filieres = new ArrayList();
		try 
		{
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete = conn.prepareStatement("SELECT * from filiere");
			ResultSet rs = requete.executeQuery();
			
			while(rs.next()) 
			{
				Salle salle = daoSalle.findById(rs.getInt("salle"));
				Filiere filiere = new Filiere(rs.getInt("id"),rs.getString("libelle"),LocalDate.parse(rs.getString("debut")),LocalDate.parse(rs.getString("fin")),salle);
				filieres.add(filiere);
			}
			
			rs.close();
			requete.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return filieres;
	}

	@Override
	public void insert(Filiere filiere) {
		try 
		{
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete = conn.prepareStatement("INSERT INTO filiere (libelle,debut,fin,salle) VALUES (?,?,?,?)");
			requete.setString(1,filiere.getLibelle());
			requete.setString(2,filiere.getDebut().toString());
			requete.setString(3,filiere.getFin().toString());
			if(filiere.getSalle()==null) 
			{
				requete.setObject(4, null);
			}
			else 
			{
				requete.setInt(4,filiere.getSalle().getId());
			}
			
			requete.executeUpdate();
			requete.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}

	@Override
	public void update(Filiere filiere) {
		try 
		{
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete = conn.prepareStatement("UPDATE filiere set libelle=?,debut=?,fin=?,salle=? where id=?");
			requete.setString(1,filiere.getLibelle());
			requete.setString(2,filiere.getDebut().toString());
			requete.setString(3,filiere.getFin().toString());
			if(filiere.getSalle()==null) 
			{
				requete.setObject(4, null);
			}
			else 
			{
				requete.setInt(4,filiere.getSalle().getId());
			}
			requete.setInt(5, filiere.getId());
			requete.executeUpdate();
			requete.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}

	@Override
	public void delete(Integer id) {
		try 
		{
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete = conn.prepareStatement("DELETE FROM filiere where id=?");
			requete.setInt(1, id);
			requete.executeUpdate();
			requete.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
