package demo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.composant.Audio;
import demo.composant.Game;
import demo.composant.Graphisme;
import demo.config.AppConfig;

public class Test {
	public static void main(String[] args) {
		
		
		//Definir la config principale Spring pour recup le context:
		
		//Config xml
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Game g1 = (Game) ctx.getBean("myGame"); //Cree dans la page AppConfig
		Game g2 = ctx.getBean("lePireJeu",Game.class); //Cree dans la page AppConfig
		
		Game g = ctx.getBean("game",Game.class); //Generé auto par le @Component sur la classe Game
		
		
		Audio audio = ctx.getBean("audio",Audio.class);
		Graphisme graphisme = (Graphisme) ctx.getBean("graphisme");
		System.out.println(g1);
		System.out.println(g2);
		System.out.println(g);
		System.out.println(audio);
		System.out.println(graphisme);
		ctx.close();
	}

}
