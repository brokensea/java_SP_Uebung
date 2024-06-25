package DAY2_25_6_2024.VariablenUndDatenstrukturen;

public class FormelsammlungRechteck {
    public static void main(String[] args) {
        FormelsammlungRechteck formelsammlungRechteck = new FormelsammlungRechteck();
        formelsammlungRechteck.formelsammlungRechteck(2, 3);
    }

    private void formelsammlungRechteck(double laenge, double breite) {
        // Berechnung des Umfangs
        double umfang = 2 * (laenge + breite);
        // Berechnung des Flächeninhalts
        double flaecheninhalt = laenge * breite;
        // Berechnung der Diagonallänge
        double diagonale = Math.sqrt(Math.pow(laenge, 2) + Math.pow(breite, 2));
        // Berechnung des Radius des Umkreises
        double umkreisRadius = diagonale / 2;
        // Ergebnisse ausgeben
        System.out.println("Umfang des Rechtecks: " + umfang);
        System.out.println("Flächeninhalt des Rechtecks: " + flaecheninhalt);
        System.out.println("Diagonallänge des Rechtecks: " + diagonale);
        System.out.println("Radius des Umkreises des Rechtecks: " + umkreisRadius);

    }

}
