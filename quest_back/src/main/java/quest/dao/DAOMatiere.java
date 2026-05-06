package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quest.model.Matiere;

public class DAOMatiere implements IDAO<Matiere,Integer>{
	private static Logger log = LoggerFactory.getLogger(DAOMatiere.class);

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
		List<Matiere> matieres = new ArrayList<>();

		// System.out.println("Chargement des matières ...");
		log.debug("Chargement des matières ...");

		// try-with-resource => va appeler le .close() à l'issu du try ou du catch, dans un block finally que le compilateur va ajouter
		try (
			Connection conn  = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select id, libelle from matiere");
			ResultSet rs =  requete.executeQuery();
		) {
			while(rs.next())
			{
				Matiere matiere = new Matiere(rs.getInt("id"),rs.getString("libelle"));
				matieres.add(matiere);
				// System.out.println("Matière " + matiere.getId() + " chargée !");
				log.info("Matière {} ({}) chargée !", matiere.getId(), matiere.getLibelle());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println("Les matières sont chargées !");
		log.debug("Les matières sont chargées !");

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
