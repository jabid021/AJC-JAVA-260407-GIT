package hopital.dao;

import java.time.LocalDate;
import java.util.List;

import hopital.context.Singleton;
import hopital.model.Visite;
import jakarta.persistence.EntityManager;

public class DAOVisite implements IDAOVisite {

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class, id);
		em.close();
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Visite> visites = em.createQuery("from Visite").getResultList();
		em.close();
		return visites;
	}

	@Override
	public Visite save(Visite visite) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			visite = em.merge(visite);
		em.getTransaction().commit();
		em.close();
		return visite;
	}

	@Override
	public void delete(Visite visite) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			visite = em.merge(visite);
			em.remove(visite);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			Visite visite = em.find(Visite.class, id);
			em.remove(visite);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void setIdPatientNull(Integer idPatient) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			em.createQuery("UPDATE Visite v set v.patient=null where v.patient.id=:id")
			.setParameter("id", idPatient)
			.executeUpdate();
			
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Visite> findByPatientId(Integer idPatient) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Visite> visites = em.createQuery("SELECT v from Visite v where v.patient.id=:id")
				.setParameter("id", idPatient)
				.getResultList();
		em.close();
		return visites;
	}

	@Override
	public List<Visite> findByMedecinIdAndDateVisiteBetween(Integer idMedecin, LocalDate debut, LocalDate fin) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Visite> visites = em.createQuery("SELECT v from Visite v where v.medecin.id=:id and v.dateVisite between :debut and :fin")
				.setParameter("id", idMedecin)
				.setParameter("debut", debut)
				.setParameter("fin", fin)
				.getResultList();
		em.close();
		return visites;
	}


}