package quest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Matiere;
import quest.model.Module;

public class DAOModule implements IDAO<Module,Integer>{

	@Override
	public Module findById(Integer id) {
		DAOMatiere daoMatiere = new DAOMatiere();
		DAOFiliere daoFiliere = new DAOFiliere();
		DAOPersonne daoPersonne = new DAOPersonne();
		Module module = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from module where id = ?");
			requete.setInt(1, id);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Matiere matiere = daoMatiere.findById(rs.getInt("matiere"));
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				Formateur formateur = (Formateur) daoPersonne.findById(rs.getInt("formateur"));
				module = new Module(rs.getInt("id"),rs.getInt("quest"),LocalDate.parse(rs.getString("debut")),LocalDate.parse(rs.getString("fin")),matiere,filiere,formateur);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return module;
	}

	@Override
	public List<Module> findAll() {
		DAOMatiere daoMatiere = new DAOMatiere();
		DAOFiliere daoFiliere = new DAOFiliere();
		DAOPersonne daoPersonne = new DAOPersonne();
		List<Module> modules = new ArrayList();
		Module module = null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from module");
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Matiere matiere = daoMatiere.findById(rs.getInt("matiere"));
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				Formateur formateur = (Formateur) daoPersonne.findById(rs.getInt("formateur"));
				module = new Module(rs.getInt("id"),rs.getInt("quest"),LocalDate.parse(rs.getString("debut")),LocalDate.parse(rs.getString("fin")),matiere,filiere,formateur);
			
				modules.add(module);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modules;
	}

	@Override
	public void insert(Module module) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("INSERT INTO module (quest,debut,fin,matiere,filiere,formateur) VALUES (?,?,?,?,?,?)");
			requete.setInt(1,module.getQuest());
			requete.setString(2, module.getDebut().toString());
			requete.setString(3, module.getFin().toString());
			requete.setInt(4, module.getMatiere().getId());
			requete.setInt(5, module.getFiliere().getId());
			if(module.getFormateur()==null) 
			{
				requete.setObject(6, null);
			}
			else 
			{
				requete.setInt(6, module.getFormateur().getId());
			}
			
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void update(Module module) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("UPDATE module set quest=?,debut=?,fin=?,matiere=?,filiere=?,formateur=? where id=?");
			requete.setInt(1,module.getQuest());
			requete.setString(2, module.getDebut().toString());
			requete.setString(3, module.getFin().toString());
			requete.setInt(4, module.getMatiere().getId());
			requete.setInt(5, module.getFiliere().getId());
			if(module.getFormateur()==null) 
			{
				requete.setObject(6, null);
			}
			else 
			{
				requete.setInt(6, module.getFormateur().getId());
			}
			requete.setInt(7, module.getId());
			
			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}

	@Override
	public void delete(Integer id) {
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("DELETE FROM module where id=?");
			requete.setInt(1,id);

			requete.executeUpdate();

			requete.close();
			conn.close();

		} catch (Exception e) {e.printStackTrace(); }
	}
	
	public List<Module> findAllByFiliereId(Integer idFiliere) {
		DAOMatiere daoMatiere = new DAOMatiere();
		DAOFiliere daoFiliere = new DAOFiliere();
		DAOPersonne daoPersonne = new DAOPersonne();
		List<Module> modules = new ArrayList();
		Module module=null;
		try {
			Connection conn = DriverManager.getConnection(urlBDD,loginBDD,passwordBDD);
			PreparedStatement requete=conn.prepareStatement("select * from module where filiere=?");
			requete.setInt(1, idFiliere);
			ResultSet rs =  requete.executeQuery();

			while(rs.next()) 
			{
				Matiere matiere = daoMatiere.findById(rs.getInt("matiere"));
				Filiere filiere = daoFiliere.findById(rs.getInt("filiere"));
				Formateur formateur = (Formateur) daoPersonne.findById(rs.getInt("formateur"));
				module = new Module(rs.getInt("id"),rs.getInt("quest"),LocalDate.parse(rs.getString("debut")),LocalDate.parse(rs.getString("fin")),matiere,filiere,formateur);
				modules.add(module);
			}
			rs.close();
			requete.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modules;
	}
	
}
