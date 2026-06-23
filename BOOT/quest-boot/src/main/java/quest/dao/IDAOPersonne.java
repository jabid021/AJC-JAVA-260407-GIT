package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Formateur;
import quest.model.Personne;
import quest.model.Stagiaire;

public interface IDAOPersonne extends JpaRepository<Personne,Integer> {

	@Query("FROM Stagiaire")
	public List<Stagiaire> findAllStagiaire();
	@Query("From Formateur")
	public List<Formateur> findAllFormateur();
	@Query("select s from Stagiaire s where s.ordinateur is null")
	public List<Stagiaire> findStagiaireWithoutOrdinateur();

	@Query("select f from Formateur f left join fetch f.affectations where f.id = :idFormateur")
	public Formateur findByIdWithModules(@Param("idFormateur") Integer idFormateur);

	public Personne findByLogin(String login);
	public Personne findByLoginAndPassword(String login,String password);
}
