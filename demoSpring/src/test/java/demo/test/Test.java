package demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.composant.Game;
import demo.composant.IConfig;
import demo.config.AppConfig;

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
		
		
		
		//ctx.close();
	}

}
