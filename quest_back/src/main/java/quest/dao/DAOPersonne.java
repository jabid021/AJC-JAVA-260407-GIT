package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Genre;
import quest.model.Personne;
import quest.model.Stagiaire;

public class DAOPersonne implements IDAO<Personne,Integer>{

	@Override
	public Personne findById(Integer id) {
		DAOFiliere daoFiliere = new DAOFiliere();
		Personne personne = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from personne where id = ?");
			requete.setInt(1, id);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_personne").equals("Stagiaire")) 
				{
					Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
					personne = new Stagiaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Genre.valueOf(rs.getString("civilite")),rs.getString("email"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),filiere);
				}
				else if(rs.getString("type_personne").equals("Formateur")) 
				{
					personne = new Formateur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Genre.valueOf(rs.getString("civilite")),rs.getBoolean("admin"));
				}
				
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		DAOFiliere daoFiliere = new DAOFiliere();
		List<Personne> personnes = new ArrayList();
		Personne personne=null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from personne");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_personne").equals("Stagiaire")) 
				{
					Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
					personne = new Stagiaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Genre.valueOf(rs.getString("civilite")),rs.getString("email"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),filiere);
				}
				else if(rs.getString("type_personne").equals("Formateur")) 
				{
					personne = new Formateur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Genre.valueOf(rs.getString("civilite")),rs.getBoolean("admin"));
				}
				personnes.add(personne);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personnes;
	}

	@Override
	public void insert(Personne personne) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("INSERT INTO personne (login,password,nom,prenom,civilite,admin,email,numero,voie,ville,cp,filiere,type_personne) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			if(personne instanceof Stagiaire) {
				Stagiaire stagiaire = (Stagiaire) personne;
				requete.setString(1,stagiaire.getLogin());
				requete.setString(2,stagiaire.getPassword());
				requete.setString(3,stagiaire.getNom());
				requete.setString(4,stagiaire.getPrenom());
				requete.setString(5,stagiaire.getCivilite().toString());
				requete.setObject(6,null);
				requete.setString(7,stagiaire.getEmail());
				requete.setString(8,stagiaire.getAdresse().getNumero());
				requete.setString(9,stagiaire.getAdresse().getVoie());
				requete.setString(10,stagiaire.getAdresse().getVille());
				requete.setString(11,stagiaire.getAdresse().getCp());
				requete.setInt(12,stagiaire.getFiliere().getId());
				requete.setString(13,"Stagiaire");
			}
			
			else if(personne instanceof Formateur) 
			{
				requete.setString(1,personne.getLogin());
				requete.setString(2,personne.getPassword());
				requete.setString(3,personne.getNom());
				requete.setString(4,personne.getPrenom());
				requete.setString(5,personne.getCivilite().toString());
				requete.setBoolean(6,((Formateur) personne).isAdmin());
				requete.setObject(7,null);
				requete.setObject(8,null);
				requete.setObject(9,null);
				requete.setObject(10,null);
				requete.setObject(11,null);
				requete.setObject(12,null);
				requete.setString(13,"Formateur");
			}

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void update(Personne personne) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("UPDATE personne set login=?,password=?,nom=?,prenom=?,civilite=?,admin=?,email=?,numero=?,voie=?,ville=?,cp=?,filiere=?,type_personne=? where id=?");
			
			if(personne instanceof Stagiaire) {
				Stagiaire stagiaire = (Stagiaire) personne;
				requete.setString(1,stagiaire.getLogin());
				requete.setString(2,stagiaire.getPassword());
				requete.setString(3,stagiaire.getNom());
				requete.setString(4,stagiaire.getPrenom());
				requete.setString(5,stagiaire.getCivilite().toString());
				requete.setObject(6,null);
				requete.setString(7,stagiaire.getEmail());
				requete.setString(8,stagiaire.getAdresse().getNumero());
				requete.setString(9,stagiaire.getAdresse().getVoie());
				requete.setString(10,stagiaire.getAdresse().getVille());
				requete.setString(11,stagiaire.getAdresse().getCp());
				requete.setInt(12,stagiaire.getFiliere().getId());
				requete.setString(13,"Stagiaire");
				requete.setInt(14, stagiaire.getId());
			}
			
			else if(personne instanceof Formateur) 
			{
				requete.setString(1,personne.getLogin());
				requete.setString(2,personne.getPassword());
				requete.setString(3,personne.getNom());
				requete.setString(4,personne.getPrenom());
				requete.setString(5,personne.getCivilite().toString());
				requete.setBoolean(6,((Formateur) personne).isAdmin());
				requete.setObject(7,null);
				requete.setObject(8,null);
				requete.setObject(9,null);
				requete.setObject(10,null);
				requete.setObject(11,null);
				requete.setObject(12,null);
				requete.setString(13,"Formateur");
				requete.setInt(14, personne.getId());
			}

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void delete(Integer id) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("DELETE FROM personne where id=?");
			requete.setInt(1,id);

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	public List<Formateur> findAllFormateur()
	{
		List<Formateur> formateurs = new ArrayList();
		Formateur formateur=null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from personne where type_personne='Formateur'");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				formateur = new Formateur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Genre.valueOf(rs.getString("civilite")),rs.getBoolean("admin"));		
				formateurs.add(formateur);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return formateurs;
	}
	public List<Stagiaire> findAllStagiaire()
	{
		DAOFiliere daoFiliere = new DAOFiliere();
		List<Stagiaire> stagiaires = new ArrayList();
		Stagiaire stagiaire=null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from personne where type_personne='Stagiaire'");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				stagiaire = new Stagiaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Genre.valueOf(rs.getString("civilite")),rs.getString("email"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),filiere);
				
				stagiaires.add(stagiaire);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stagiaires;
	}
	

	public Personne findByLoginAndPassword(String login,String password) 
	{
		DAOFiliere daoFiliere = new DAOFiliere();
		Personne personne = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from personne where login=? and password=?");
			requete.setString(1, login);
			requete.setString(2, password);
			
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_personne").equals("Stagiaire")) 
				{
					Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
					personne = new Stagiaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Genre.valueOf(rs.getString("civilite")),rs.getString("email"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),filiere);
				}
				else if(rs.getString("type_personne").equals("Formateur")) 
				{
					personne = new Formateur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),Genre.valueOf(rs.getString("civilite")),rs.getBoolean("admin"));
				}
				
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return personne;
	};

	
	
}
