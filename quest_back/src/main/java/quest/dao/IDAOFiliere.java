package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere,Integer> {

	@Query("SELECT f from Filiere f LEFT JOIN FETCH f.cours where f.id=:idFiliere")
	public Filiere findByIdWithModules(Integer idFiliere);
}
