package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import fr.formation.exception.CantDivideByZeroException;
import fr.formation.exception.NegativeNotAllowedException;

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

    @Test
    void shouldThrowCantDivideByZeroException() {
        // given
        int a = 5;
        int b = 0;

        // when & then
        Assertions.assertThrows(
            CantDivideByZeroException.class,
            () -> this.calc.divide(a, b)
        );
    }

    @Test
    void shouldAddReturn0WhenNull() {
        // given
        String value = null;

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldAddReturn0WhenEmpty() {
        // given
        String value = "";

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldAddReturn2When2() {
        // given
        String value = "2";

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldAddReturn3When3() {
        // given
        String value = "3";

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldAddReturn36When12And5And19() {
        // given
        String value = "12,5,19";

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(36, result);
    }

    @Test
    void shouldAddReturn30When12And18() {
        // given
        String value = "12,18";

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(30, result);
    }

    @Test
    void shouldAddThrowNegativeNotAllowedException() {
        // given
        String value = "10,-5,8";

        // when & then
        Assertions.assertThrows(
            NegativeNotAllowedException.class,
            () -> this.calc.add(value)
        );
    }

    @Test
    void shouldAddReturn20When8And12SemiColon() {
        // given
        String value = "8;12";

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(20, result);
    }

    @Test
    void shouldAddReturn36When12And5And19NewLine() {
        // given
        String value = "12\n5\n19";

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(36, result);
    }

    @Test
    void shouldAddReturn56When12And5And19Mixin() {
        // given
        String value = "12,5;19\n20";

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(56, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "null:0",
        "'':0",
        "2:2",
        "15:15",
        "12,5,19:36",
        "12;5;19:36",
        "'12\n5\n19':36"
    }, delimiter = ':', nullValues = "null")
    void shouldAddStringReturnOk(String value, int expected) {
        // given

        // when
        int result = this.calc.add(value);

        // then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-2",
        "15,-15",
        "12;-5;19",
        "'12\n-5\n19'"
    }, delimiter = ':')
    void shouldAddStringThrowNegativeNotAllowedException(String value) {
        // given

        // when & then
        Assertions.assertThrows(
            NegativeNotAllowedException.class,
            () -> this.calc.add(value)
        );
    }
}
