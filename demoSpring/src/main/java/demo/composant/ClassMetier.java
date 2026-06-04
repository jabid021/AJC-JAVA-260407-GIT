package demo.composant;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class ClassMetier {
	
	public void demoClassMetier() 
	{
		System.out.println("--------Traitement de la methode-----------");
	}
	
	public void demoClassMetier2() 
	{
		System.out.println("--------Traitement de la methode 2-----------");
	}
	
	
	public String demo3MetierPossibleExceptionEtReturn(String message) throws Exception
	{
		
		System.out.println("------Debut de la methode metier--------");
		System.out.println("Le message recu en para : "+message);
		
		Random r = new Random();
		if(r.nextInt(2)==0) 
		{
			throw new Exception("Pas de chance, ca plante...");
		}
		return "Un string qu'on retourne";
	}
}
