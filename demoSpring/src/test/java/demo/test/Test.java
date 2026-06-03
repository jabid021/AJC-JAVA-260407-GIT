package demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.composant.Audio;
import demo.composant.Game;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		Game g1 = (Game) ctx.getBean("myGame");
		Game g2 = ctx.getBean("lePireJeu",Game.class);
		
		Audio audio = ctx.getBean(Audio.class);
		
		System.out.println(g1);
		System.out.println(g2);
		System.out.println(audio);
		ctx.close();
	}

}
