package DAY2_25_6_2024.VariablenUndDatenstrukturen;

/* Hier sind einige Übungsaufgaben,um die Verwendung der      *Klasse**`java.lang.Math`**in Java zu üben:
*/
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MathBibliothek {
    public static void main(String[] args) {
        MathBibliothek mathBibliothek = new MathBibliothek();
        mathBibliothek.rechnenAbsoluteZahl(-1);
        mathBibliothek.rechnenExponentiation(2, 3);
        mathBibliothek.rechnenNatuerlicherLogarithmus(100);
        mathBibliothek.rechnenQuadratwurzel(9);
        mathBibliothek.rechnenRundenZahl(10.1234, 2);
        mathBibliothek.rechnenZufaelligeGanzzahl(5, 9);
    }

    // Quadratwurzel berechnen: Schreibe ein Programm, das die Quadratwurzel einer
    // gegebenen Zahl berechnet und das Ergebnis ausgibt.
    private double rechnenQuadratwurzel(double zahl) {
        double quadratwurzel = Math.sqrt(zahl);
        System.out.println("Math.sqrt(zahl) " + quadratwurzel);
        return quadratwurzel;
    }

    // Potenz berechnen: Schreibe ein Programm, das die Potenz einer Basis zur
    // Exponentiation berechnet und das Ergebnis ausgibt.
    private double rechnenExponentiation(double basis, double exponent) {
        double exponentiation = Math.pow(basis, exponent);
        System.out.println("Math.pow(basis, exponent); " + exponentiation);
        return exponentiation;
    }

    // Absolute Zahl berechnen: Schreibe ein Programm, das die absolute Zahl einer
    // gegebenen Zahl berechnet und das Ergebnis ausgibt.
    private double rechnenAbsoluteZahl(double zahl) {
        double absoluteZahl = Math.abs(zahl);
        System.out.println("Math.abs(zahl); " + absoluteZahl);
        return absoluteZahl;
    }

    // Runden: Schreibe ein Programm, das eine Gleitkommazahl auf eine bestimmte
    // Anzahl von Dezimalstellen rundet und das Ergebnis ausgibt.
    private BigDecimal rechnenRundenZahl(double zahl, int dezimalstellen) {
        // Runden der Zahl auf die gewünschte Anzahl von Dezimalstellen
        BigDecimal rundenZahl = new BigDecimal(zahl).setScale(dezimalstellen, RoundingMode.HALF_UP);
        System.out.println(
                "Die Zahl " + zahl + " gerundet auf " + dezimalstellen + " Dezimalstellen ist: " + rundenZahl);
        return rundenZahl;
    }

    // Zufällige Zahl generieren: Schreibe ein Programm, das eine zufällige Ganzzahl
    // oder Gleitkommazahl innerhalb eines bestimmten Bereichs generiert und das
    // Ergebnis ausgibt.
    private int rechnenZufaelligeGanzzahl(int untereGrenze, int obereGrenze) {
        Random random = new Random();
        // Zufällige Ganzzahl im Bereich [untereGrenze, obereGrenze] generieren
        int zufaelligeGanzzahl = random.nextInt(obereGrenze - untereGrenze + 1) + untereGrenze;
        return zufaelligeGanzzahl;
    }

    // Natürlicher Logarithmus berechnen: Schreibe ein Programm, das den natürlichen
    // Logarithmus einer gegebenen Zahl berechnet und das Ergebnis ausgibt.
    private double rechnenNatuerlicherLogarithmus(double zahl) {
        double natuerlicherLogarithmus = Math.log(zahl);
        System.out.println("Math.log(zahl); " + natuerlicherLogarithmus);
        return natuerlicherLogarithmus;
    }
}
