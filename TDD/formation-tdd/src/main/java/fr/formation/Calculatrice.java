package fr.formation;

import java.util.stream.Stream;

import fr.formation.exception.CantDivideByZeroException;
import fr.formation.exception.NegativeNotAllowedException;

public class Calculatrice {
    public int add(int a, int b) {
        // if (a == 6 && b == 9) {
        //     return 15;
        // }

        // return 11;

        return a + b;
    }

    public int add(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        // String[] intStrings = value.split("[,;\\n]+");
        // int total = 0;

        // for (String intString : intStrings) {
        //     int intVal = Integer.parseInt(intString);

        //     if (intVal < 0) {
        //         throw new NegativeNotAllowedException();
        //     }

        //     total += intVal;
        // }

        // return total;

        return Stream.of(value.split("[,;\\n]+"))
            .mapToInt(val -> {
                int intVal = Integer.parseInt(val);

                if (intVal < 0) {
                    throw new NegativeNotAllowedException();
                }

                return intVal;
            })
            .sum()
        ;
    }

    public float divide(int a, int b) {
        if (b == 0) {
            throw new CantDivideByZeroException();
        }

        return 0;
    }
}
