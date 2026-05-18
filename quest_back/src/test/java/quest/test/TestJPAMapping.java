package quest.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestJPAMapping {

	public static void main(String[] args) {
		Configurator.setRootLevel(Level.INFO);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		
		emf.close();

	}

}
