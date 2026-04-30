package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import quest.model.Salle;

public class DAOSalle implements IDAO<Salle,Integer>{

	@Override
	public Salle findById(Integer id) {
		Salle salle = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from salle where id = ?");
			requete.setInt(1, id);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				salle = new Salle(rs.getInt("id"),rs.getString("nom"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return salle;
	}

	@Override
	public List<Salle> findAll() {
		List<Salle> salles = new ArrayList();
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from salle");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Salle salle = new Salle(rs.getInt("id"),rs.getString("nom"),rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				salles.add(salle);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return salles;
	}

	@Override
	public void insert(Salle salle) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("INSERT INTO salle (nom,numero,voie,ville,cp) VALUES (?,?,?,?,?)");
			requete.setString(1,salle.getNom());
			requete.setString(2,salle.getAdresse().getNumero());
			requete.setString(3,salle.getAdresse().getVoie());
			requete.setString(4,salle.getAdresse().getVille());
			requete.setString(5,salle.getAdresse().getCp());

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void update(Salle salle) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("UPDATE salle set nom=?,numero=?,voie=?,ville=?,cp=? where id=?");
			requete.setString(1,salle.getNom());
			requete.setString(2,salle.getAdresse().getNumero());
			requete.setString(3, salle.getAdresse().getVoie());
			requete.setString(4,salle.getAdresse().getVille());
			requete.setString(5,salle.getAdresse().getCp());
			requete.setInt(6, salle.getId());


			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void delete(Integer id) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("DELETE FROM salle where id=?");
			requete.setInt(1,id);

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

}
