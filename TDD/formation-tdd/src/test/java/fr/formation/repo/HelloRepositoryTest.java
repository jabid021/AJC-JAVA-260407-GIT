package fr.formation.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloRepositoryTest {
    @Autowired
    private HelloRepository repository;

    @Test
    void shouldCountOk() {
        // given

        // when
        long result = this.repository.count();

        // then
        Assertions.assertEquals(0, result);
    }
}
