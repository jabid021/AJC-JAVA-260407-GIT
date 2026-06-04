package orchestre.aspect;

public class PublicAspect {


	public void afterToStringGuitariste(String returnToString) 
	{
		System.out.println(returnToString);
		System.out.println("Le guitariste vient de se presenter");
	}
	
	
	public void installer(){System.out.println("Le public s'installe");}
	
	
	public void applaudir(){System.out.println("Le public applaudit");}
	
	
	public void huer(){System.out.println("Le public jette des tomates");}

}
