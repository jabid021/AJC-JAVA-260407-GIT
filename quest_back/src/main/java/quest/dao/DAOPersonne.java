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
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Stagiaire> stagiaires =
				em.createQuery(
						"select s from Stagiaire s",
						Stagiaire.class)
				  .getResultList();

		em.close();

		return stagiaires;
	}

	@Override
	public List<Formateur> findAllFormateur() {
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Formateur> formateurs =
				em.createQuery(
						"select f from Formateur f",
						Formateur.class)
				  .getResultList();

		em.close();

		return formateurs;
	}

	@Override
	public List<Stagiaire> findStagiaireWithoutOrdinateur() {
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Stagiaire> stagiaires =
				em.createQuery(
						"""
						select s
						from Stagiaire s
						where s.ordinateur is null
						""",
						Stagiaire.class)
				  .getResultList();

		em.close();

		return stagiaires;
	}

	@Override
	public Formateur findByIdWithModules(Integer idFormateur) {
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Formateur formateur = null;

		try {

			formateur =
					em.createQuery(
							"""
							select distinct f
							from Formateur f
							left join fetch f.modules
							where f.id = :idFormateur
							""",
							Formateur.class)
					  .setParameter("idFormateur", idFormateur)
					  .getSingleResult();

		} catch (Exception e) {

			formateur = null;

		} finally {

			em.close();
		}

		return formateur;
	}

	@Override
	public Personne findByLoginAndPassword(String login, String password) {
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Personne personne = null;

		try {

			personne =
					em.createQuery(
							"""
							select p
							from Personne p
							where p.login = :login
							and p.password = :password
							""",
							Personne.class)
					  .setParameter("login", login)
					  .setParameter("password", password)
					  .getSingleResult();

		} catch (Exception e) {

			personne = null;

		} finally {

			em.close();
		}

		return personne;
		
		
	}


}
