package demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class DemoAspect {
	
	@Pointcut("execution(public void demo.composant.ClassMetier.demoClassMetier())")
	public void monPointCut() {}
	
	
	@Before("execution(public void demo.composant.ClassMetier.*())")
	public void seLanceAvantDemo() 
	{
		System.out.println("Methode dans DemoAspect qui se lance BEFORE la methode demo de la classe ClassMetier");
	}
	

	@After("monPointCut()")
	public void seLanceApresDemo() 
	{
		System.out.println("Methode dans DemoAspect qui se lance AFTER la methode demo de la classe ClassMetier");
	}
	
	
	@Around("monPointCut()")
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
	
	
	
	@AfterReturning(pointcut = "execution(public String demo.composant.*.demo3MetierPossibleExceptionEtReturn(String))", returning ="leNomDuReturnClassMetier" )
	public void seLanceSiToutOkDansDemo3(String leNomDuReturnClassMetier) 
	{
		System.out.println("Tout s'est bien passe dans demo3");
		System.out.println("On a recup dans l'autre methode le String suivant : "+leNomDuReturnClassMetier);
	}
	
	
	@AfterThrowing(pointcut = "execution(public String demo.composant.*.demo3MetierPossibleExceptionEtReturn(String))", throwing = "e")
	public void seLanceSiExceptionDemo3(Exception e) 
	{
		System.out.println("Demo 3 a eu un soucis,  voici son message : "+e.getMessage());
	}
}
