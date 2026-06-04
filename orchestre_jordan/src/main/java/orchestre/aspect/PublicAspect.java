package orchestre.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublicAspect {

	@AfterReturning(returning = "returnToString",pointcut = "execution(public String orchestre.model.Guitariste.toString())" )
	public void afterToStringGuitariste(String returnToString) 
	{
		System.out.println(returnToString);
		System.out.println("Le guitariste vient de se presenter");
	}
	
	@Pointcut("execution(public void orchestre.model.Guitariste.jouer())")
	public void methodeJouerGuitariste() {}
	
	
	@Before("methodeJouerGuitariste()")
	public void installer(){System.out.println("Le public s'installe");}
	
	@AfterReturning("methodeJouerGuitariste()")
	public void applaudir(){System.out.println("Le public applaudit");}
	
	@AfterThrowing(pointcut = "methodeJouerGuitariste()", throwing = "e")
	public void huer(Exception e)
	{
		System.out.println(e.getMessage());
		System.out.println("Le public jette des tomates");
	}

}
