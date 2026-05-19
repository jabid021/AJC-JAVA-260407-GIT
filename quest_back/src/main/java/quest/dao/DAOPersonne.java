package quest.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import quest.context.Singleton;
import quest.model.Formateur;
import quest.model.Personne;
import quest.model.Stagiaire;

public class DAOPersonne implements IDAOPersonne {

	@Override
	public Personne findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personne personne = em.find(Personne.class, id);
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Personne> personnes = em.createQuery("from Personne").getResultList();
		em.close();
		return personnes;
	}

	@Override
	public Personne save(Personne personne) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			personne = em.merge(personne);
		em.getTransaction().commit();
		em.close();
		return personne;
	}

	@Override
	public void delete(Personne personne) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			personne = em.merge(personne);
			em.remove(personne);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			Personne personne = em.find(Personne.class, id);
			em.remove(personne);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Stagiaire> findAllStagiaire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Formateur> findAllFormateur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stagiaire> findStagiaireWithoutOrdinateur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formateur findByIdWithModules(Integer idFormateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne findByLoginAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
