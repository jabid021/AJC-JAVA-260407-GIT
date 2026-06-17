package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere,Integer> {

	@Query("SELECT f from Filiere f LEFT JOIN FETCH f.cours where f.id=:idFiliere")
	public Filiere findByIdWithModules(@Param("idFiliere") Integer idFiliere);
	
	@Query("SELECT f from Filiere f LEFT JOIN FETCH f.stagiaires where f.id=:idFiliere")
	public Filiere findByIdWithStagiaires(@Param("idFiliere") Integer idFiliere);
}
