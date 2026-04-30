package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import quest.model.Matiere;

public class DAOMatiere implements IDAO<Matiere,Integer>{

	@Override
	public Matiere findById(Integer id) {
		Matiere matiere = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from matiere where id = ?");
			requete.setInt(1, id);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				matiere = new Matiere(rs.getInt("id"),rs.getString("libelle"));
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		List<Matiere> matieres = new ArrayList();
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from matiere");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Matiere matiere = new Matiere(rs.getInt("id"),rs.getString("libelle"));
				matieres.add(matiere);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return matieres;
	}

	@Override
	public void insert(Matiere matiere) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("INSERT INTO matiere (libelle) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
			requete.setString(1,matiere.getLibelle());

			requete.executeUpdate();


			ResultSet rs = requete.getGeneratedKeys();
			if(rs.next()){
				matiere.setId(rs.getInt(1));
			}

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void update(Matiere matiere) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("UPDATE matiere set libelle=? where id=?");
			requete.setString(1,matiere.getLibelle());
			requete.setInt(2, matiere.getId());
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void delete(Integer id) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("DELETE FROM matiere where id=?");
			requete.setInt(1,id);

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

}
