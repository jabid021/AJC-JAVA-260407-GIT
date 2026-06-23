package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatriceTest {
    private Calculatrice calc;

    @BeforeEach
    void setup() {
        this.calc = new Calculatrice();
    }

    @Test
    void shouldReturn11When5And6() {
        // given / arrange
        int a = 5;
        int b = 6;

        // when / act
        int result = calc.add(a, b);

        // then / assert
        Assertions.assertEquals(11, result);
    }

    @Test
    void shouldReturn15When6And9() {
        // given / arrange
        int a = 6;
        int b = 9;

        // when / act
        int result = calc.add(a, b);

        // then / assert
        Assertions.assertEquals(15, result);
    }

    @ParameterizedTest
    @CsvSource({
        "5,6,11",
        "6,9,15",
        "0,0,0",
        "0,4,4",
        "7,8,15",
        "-15,15,0"
    })
    void shouldAdditionOk(int a, int b, int expected) {
        // given / arrange

        // when / act
        int result = calc.add(a, b);

        // then / assert
        Assertions.assertEquals(expected, result);
    }
}
