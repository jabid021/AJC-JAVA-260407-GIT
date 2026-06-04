package quest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import quest.model.Module;

@Repository
@Transactional
public class DAOModule implements IDAOModule {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Module findById(Integer id) {
		return em.find(Module.class, id);
	}

	@Override
	public List<Module> findAll() {
		return em.createQuery("from Module").getResultList();
	}

	@Override
	public Module save(Module module) {
		return em.merge(module);
	}

	@Override
	public void delete(Module module) {
		module = em.merge(module);
		em.remove(module);
	}

	@Override
	public void deleteById(Integer id) {
		Module module = em.find(Module.class, id);
		em.remove(module);
	}

	@Override
	public List<Module> findAllByFiliereId(Integer idFiliere) {
		return em.createQuery(
				"select  from Module m where m.modules.id = :idFiliere",
				Module.class)
		.setParameter("idModule", idFiliere)
		.getResultList();	
	}


}
