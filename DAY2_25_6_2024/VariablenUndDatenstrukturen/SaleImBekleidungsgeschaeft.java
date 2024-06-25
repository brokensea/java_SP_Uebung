package DAY2_25_6_2024.VariablenUndDatenstrukturen;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SaleImBekleidungsgeschaeft {
    public static void main(String[] args) {
        SaleImBekleidungsgeschaeft saleImBekleidungsgeschaeft = new SaleImBekleidungsgeschaeft();
        double preis = saleImBekleidungsgeschaeft.preisRechnen(105.33);
        System.out.println("Gerundeter Preis: " + preis);
    }

    private double preisRechnen(double preis) {
        preis = preis * (1 - 0.4);
        preis = rechnenRundenZahl(preis, 2).doubleValue();

        return preis;
    }

    private BigDecimal rechnenRundenZahl(double zahl, int dezimalstellen) {
        // Runden der Zahl auf die gewünschte Anzahl von Dezimalstellen
        BigDecimal rundenZahl = new BigDecimal(zahl).setScale(dezimalstellen, RoundingMode.HALF_UP);
        System.out.println(
                "Die Zahl " + zahl + " gerundet auf " + dezimalstellen + " Dezimalstellen ist: " + rundenZahl);
        return rundenZahl;
    }
}