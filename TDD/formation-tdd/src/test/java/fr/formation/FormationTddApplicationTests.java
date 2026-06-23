package fr.formation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// SpringBootTest permet de charger TOUT le context de Spring pour le test unitaire
// @SpringBootTest

// WebMvcTest permet de ne charger QUE la partie Web + Securité de base
// @WebMvcTest

// DataJpaTest chargement UNIQUEMENT la partie Hibernate / JPA + DATA-JPA
// @DataJpaTest

@SpringBootTest
// @WebMvcTest
// @DataJpaTest
class FormationTddApplicationTests {
	@Test
	void contextLoads() {
	}
}
