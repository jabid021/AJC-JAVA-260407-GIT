package fr.formation.repo;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import fr.formation.model.Produit;

@DataJpaTest
public class ProduitRepositoryTest {
    @Autowired
    private ProduitRepository repository;

    @Test
    @Sql(scripts = "classpath:/create-produit.sql")
    void shouldFindAllByPrixBetweenOk() {
        // given
        BigDecimal x = new BigDecimal("450");
        BigDecimal y = new BigDecimal("1650");

        // when
        List<Produit> result = this.repository.findAllByPrixBetween(x, y);

        // then
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(2, result.size());
    }
}
