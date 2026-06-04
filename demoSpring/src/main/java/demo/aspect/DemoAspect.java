package demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class DemoAspect {
	
	public void seLanceAvantDemo() 
	{
		System.out.println("Methode dans DemoAspect qui se lance BEFORE la methode demo de la classe ClassMetier");
	}
	

	public void seLanceApresDemo() 
	{
		System.out.println("Methode dans DemoAspect qui se lance AFTER la methode demo de la classe ClassMetier");
	}
	
	
	public void seLanceAutours(ProceedingJoinPoint pj) 
	{
		System.out.println("Methode dans DemoAspect qui se lance BEFORE (Via Around) la methode demo de la classe ClassMetier");

		try {
			pj.proceed(); // va lancer le System.out.println("--------Traitement de la methode-----------"); de la methode qu'on ecoute
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Methode dans DemoAspect qui se lance AFTER (Via Around) la methode demo de la classe ClassMetier");
	}
	
	
	
	
	public void seLanceSiToutOkDansDemo3(String leNomDuReturnClassMetier) 
	{
		System.out.println("Tout s'est bien passe dans demo3");
		System.out.println("On a recup dans l'autre methode le String suivant : "+leNomDuReturnClassMetier);
	}
	
	
	public void seLanceSiExceptionDemo3(Exception e) 
	{
		System.out.println("Demo 3 a eu un soucis,  voici son message : "+e.getMessage());
	}
}
