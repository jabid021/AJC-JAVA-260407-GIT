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
        Assertions.assertFalse(matieres.isEmpty());
        Assertions.assertNotEquals(0, matieres.get(0).getId());
        Assertions.assertNotNull(matieres.get(0).getLibelle());
        Assertions.assertFalse(matieres.get(0).getLibelle().isEmpty());
    }
}
