package fr.formation.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fr.formation.model.Hello;

// @SpringBootTest
@DataJpaTest // @Transactional & @Rollback sont implicites
public class HelloRepositoryTest {
    @Autowired
    private HelloRepository repository;

    @Test
    // @Transactional // Permet d'activer le Rollback
    // @Rollback // Le Rollback annule l'insertion / la modification / la suppression
    void shouldSaveOk() {
        // given
        Hello hello = new Hello();

        hello.setMessage("Hello world!");

        // When
        this.repository.save(hello);

        // then
        // Assertions.assertNotEquals(0, hello.getId());
        Assertions.assertNotNull(hello.getId());
    }

    @Test
    void shouldCountOk() {
        // given

        // when
        long result = this.repository.count();

        // then
        Assertions.assertEquals(0, result);
    }
}
