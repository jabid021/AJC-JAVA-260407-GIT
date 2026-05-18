package krusty.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import krusty.context.Singleton;
import krusty.model.Client;
import krusty.model.Employe;
import krusty.model.Patron;
import krusty.model.Personnage;

public class DAOPersonnage implements IDAOPersonnage {

	@Override
	public Personnage findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personnage personnage = em.find(Personnage.class, id);
		em.close();
		return personnage;
	}

	@Override
	public List<Personnage> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Personnage> personnages = em.createQuery("from Personnage").getResultList();
		em.close();
		return personnages;
	}

	@Override
	public Personnage save(Personnage personnage) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			personnage = em.merge(personnage);
		em.getTransaction().commit();
		em.close();
		return personnage;
	}

	@Override
	public void delete(Personnage personnage) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			personnage = em.merge(personnage);
			em.remove(personnage);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			Personnage personnage = em.find(Personnage.class, id);
			em.remove(personnage);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Client> findAllClient() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Client> clients = em.createQuery("from Client").getResultList();
		em.close();
		return clients;
	}

	@Override
	public List<Patron> findAllPatron() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Patron> patrons = em.createQuery("from Patron").getResultList();
		em.close();
		return patrons;
	}

	@Override
	public List<Employe> findAllEmploye() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Employe> employes = em.createQuery("from Employe").getResultList();
		em.close();
		return employes;
	}

	@Override
	public Client findByIdWithAchats(Integer idClient) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Client client = null;
		try {
		client = em.createQuery("SELECT c from Client c LEFT JOIN FETCH c.achats where c.id=:id",Client.class)
				.setParameter("id", idClient)
				.getSingleResult();
		}catch(Exception e) {e.printStackTrace();}
		em.close();
		return client;
	}

}
