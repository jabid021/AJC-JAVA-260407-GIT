package demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.composant.Audio;
import demo.composant.Game;
import demo.composant.Graphisme;

public class Test {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		//Game g1 = (Game) ctx.getBean("myGame");
		//Game g2 = ctx.getBean("lePireJeu",Game.class);
		Game g = ctx.getBean(Game.class);
		Audio audio = ctx.getBean(Audio.class);
		Graphisme graphisme = (Graphisme) ctx.getBean("graphisme");
		//System.out.println(g1);
		//System.out.println(g2);
		System.out.println(g);
		System.out.println(audio);
		System.out.println(graphisme);
		ctx.close();
	}

}
