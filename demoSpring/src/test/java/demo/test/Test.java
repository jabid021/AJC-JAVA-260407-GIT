package demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import demo.composant.ClassMetier;
import demo.composant.Game;
import demo.composant.IConfig;

public class Test {
	
	@Autowired
	Game myGame;
	
	@Autowired
	Game lePireJeu;
	
	@Autowired
	@Qualifier("game")
	Game unAutrenom;
	
	@Autowired
	IConfig audio;
	
	@Autowired
	IConfig graphisme;
	
	@Autowired
	ClassMetier cm;
	
	
	public void run() {
		//Definir la config principale Spring pour recup le context:
		
		//Config xml
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Game g1 = (Game) ctx.getBean("myGame"); //Cree dans la page AppConfig
		//Game g2 = ctx.getBean("lePireJeu",Game.class); //Cree dans la page AppConfig
		
		//Game g = ctx.getBean("game",Game.class); //Generé auto par le @Component sur la classe Game
		
		
		//Audio audio = ctx.getBean("audio",Audio.class);
		//Graphisme graphisme = (Graphisme) ctx.getBean("graphisme");
		System.out.println(myGame);
		System.out.println(lePireJeu);
		System.out.println(unAutrenom);
		System.out.println(audio);
		System.out.println(graphisme);
		
		System.out.println("--------------");
		
		System.out.println("DEMO AOP");
		cm.demoClassMetier();
		
		System.out.println("------");
		
		try {
			cm.demo3MetierPossibleExceptionEtReturn("Un message random en param");
		}
		catch(Exception e) {e.printStackTrace();}
		//ctx.close();
	}

}
