package orchestre;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.Flutiste;
import orchestre.model.Guitariste;
import orchestre.model.IMusicien;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		IMusicien jordan = ctx.getBean(Guitariste.class);
		IMusicien flutiste = ctx.getBean(Flutiste.class);
		
		pianiste.jouer();
		jordan.jouer();
		flutiste.jouer(); 

	}

}
