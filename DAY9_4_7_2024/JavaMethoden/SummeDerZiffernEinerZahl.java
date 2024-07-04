package DAY9_4_7_2024.JavaMethoden;

import javax.swing.text.Style;

//Sum of the digits of a number
// Implementiere eine rekursive Methode in Java,die die Summe der Ziffern einer gegebenen Zahl berechnet:

// ```java 456789->4+5+6+7+8+9=39```

// -Stelle sicher,dass die Methode korrekt für alle nicht-negativen ganzen Zahlen funktioniert-Führe Tests mit verschiedenen Zahlen durch,um die Korrektheit der Methode zu überprüfen-Dokumentiere deinen Code,um die Funktionsweise der Methode klar zu erläutern
public class SummeDerZiffernEinerZahl {
    public static void main(String[] args) {
        SummeDerZiffernEinerZahl summeDerZiffernEinerZahl = new SummeDerZiffernEinerZahl();

        System.out.println(summeDerZiffernEinerZahl.sumDigitsNumber(4567890));

    }

    /**
     * 456789->4+5+6+7+8+9=39
     * 
     * @param number biger than 0 int.
     * @return int
     */
    private int sumDigitsNumber(int number) {
        if (number <= 0) {
            return 0;
        }
        return number % 10 + sumDigitsNumber(number / 10);
    }
}
