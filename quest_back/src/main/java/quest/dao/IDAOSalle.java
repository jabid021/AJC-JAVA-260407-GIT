package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Salle;

public interface IDAOSalle extends JpaRepository<Salle,Integer> {

	@Query("SELECT s from Salle s LEFT JOIN FETCH s.historique")
	public List<Salle> findAllWithHistorique();
	
	@Query("SELECT s from Salle s LEFT JOIN FETCH s.historique where s.id=:id")
	public Salle findByIdWithHistorique(@Param("id") Integer id);
}
