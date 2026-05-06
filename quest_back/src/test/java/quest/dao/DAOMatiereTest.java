package quest.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import quest.model.Matiere;

public class DAOMatiereTest {
    @Test
    void shouldLoadMatieres() {
        // Given
        DAOMatiere daoMatiere = new DAOMatiere();

        // When
        List<Matiere> matieres = daoMatiere.findAll();

        // Then
        Assertions.assertNotNull(matieres);
        Assertions.assertEquals(4, matieres.size());
        Assertions.assertEquals(1, matieres.get(0).getId());
        Assertions.assertEquals("SPRING BOOT", matieres.get(0).getLibelle());
    }
}
