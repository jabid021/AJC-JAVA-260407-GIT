package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import demo.composant.Game;

@Configuration
@ComponentScan({"demo.composant","demo.aspect"})
@EnableAspectJAutoProxy
//@ImportResource("classpath:application-context.xml") //Permet d'aller lire la config dans le fichier xml en + de la config JAVA
public class AppConfig {

	/*<bean id="myGame" class="demo.composant.Game">
	<property name="audio" ref="audio"/>
	<property name="configGraphisme" ref="graphisme"/>
	<property name="nom" value="PPDS"/>
	</bean>*/

	
	@Bean
	public Game myGame() 
	{
		Game g = new Game();
		g.setNom("PPDS");
		return  g;
	}
	
	
	@Bean(name = "lePireJeu")
	public Game unAutreNom() 
	{
		Game g = new Game();
		g.setNom("LoL");
		return  g;
	}
	
	
	@Bean
	public Game game() 
	{
		Game g = new Game();
		g.setNom("TPT");
		return  g;
	}
	
	
}
