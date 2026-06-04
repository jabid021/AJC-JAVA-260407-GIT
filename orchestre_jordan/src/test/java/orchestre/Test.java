package orchestre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import orchestre.model.IMusicien;

public class Test {

	@Autowired
	IMusicien pianiste;
	
	@Autowired
	@Qualifier("guitariste")
	IMusicien jordan;
	
	@Autowired
	
	IMusicien flutiste;
	
	
	
	public void run() {
		
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		//IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		//IMusicien jordan = ctx.getBean(Guitariste.class);
		//IMusicien flutiste = ctx.getBean("musicien",Flutiste.class);
		
		/*pianiste.jouer();
		jordan.jouer();
		flutiste.jouer(); */
		
		jordan.toString();
		
		System.out.println("----DEBUT DU CONCERT----");

		try {
		    jordan.jouer();
		}catch(Exception e) 
		    {
		        System.out.println(e.getMessage());
		    }
		        
		System.out.println("---FIN DU CONCERT----");

	}

}
