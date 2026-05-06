package quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
    // private Calc calc = new Calc();
    private Calc calc;

    // S'exécuter avant CHAQUE test unitaire
    @BeforeEach
    void setup() {
        this.calc = new Calc();
    }

    @Test
    void firstTest() {
        // Given
        // Calc calc = new Calc();

        // When
        int result = calc.additionner(5, 4);

        // Then
        Assertions.assertEquals(9, result);
    }

    @Test
    void shouldAddReturn15When10And5() {
        // Given
        // Calc calc = new Calc();
        int a = 10;
        int b = 5;

        // When
        int result = calc.additionner(a, b);

        // Then
        Assertions.assertEquals(15, result);
    }
}
