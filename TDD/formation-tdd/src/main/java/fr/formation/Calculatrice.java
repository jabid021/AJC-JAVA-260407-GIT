package fr.formation;

import fr.formation.exception.CantDivideByZeroException;

public class Calculatrice {
    public int add(int a, int b) {
        // if (a == 6 && b == 9) {
        //     return 15;
        // }

        // return 11;

        return a + b;
    }

    public float divide(int a, int b) {
        if (b == 0) {
            throw new CantDivideByZeroException();
        }

        return 0;
    }
}
