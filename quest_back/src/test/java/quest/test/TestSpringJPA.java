package quest.test;

import org.springframework.beans.factory.annotation.Autowired;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;
import quest.model.Matiere;
import quest.service.MatiereService;

public class TestSpringJPA {

	@Autowired
	IDAOFiliere daoFiliere;
	
	@Autowired
	MatiereService matiereSrv;
	
	public void run() 
	{
		System.out.println("ALLLO");
		for(Filiere f : daoFiliere.findAll()) 
		{
			System.out.println(f);
		}
		
		
		for(Matiere m  : matiereSrv.getAll()) 
		{
			System.out.println(m);
		}
	}
}
