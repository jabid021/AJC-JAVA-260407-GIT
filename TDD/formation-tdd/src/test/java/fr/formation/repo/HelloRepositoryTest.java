package fr.formation.repo;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

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

    @Test
    // @Sql permet d'exécuter une instruction SQL (ou un script SQL) avant (ou après) le test unitaire
    // @Sql(statements = "INSERT INTO hello (message) VALUES ('Hello world!')")
    @Sql(scripts = "classpath:/create-hello.sql")
    void shouldFindByIdPresent() {
        // given
        int id = 1;

        // when
        Optional<Hello> optHello = this.repository.findById(id);

        // then
        Assertions.assertTrue(optHello.isPresent());
        Assertions.assertEquals("Hello world!", optHello.get().getMessage());
    }
}
