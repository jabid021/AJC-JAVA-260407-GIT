package quest.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import quest.config.AppConfig;
import quest.model.Matiere;

@SpringJUnitConfig(AppConfig.class)
public class DAOMatiereTest {
	
	@Autowired
	IDAOMatiere daoMatiere;
	
    @Test
    void shouldLoadMatieres() {
        // When
        List<Matiere> matieres = daoMatiere.findAll();

        // Then
        Assertions.assertNotNull(matieres);
        Assertions.assertFalse(matieres.isEmpty());
        Assertions.assertNotEquals(0, matieres.get(0).getId());
        Assertions.assertNotNull(matieres.get(0).getLibelle());
        Assertions.assertFalse(matieres.get(0).getLibelle().isEmpty());
    }
}
