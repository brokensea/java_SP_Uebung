package DAY3_26_6_2026.javaKontrollstrukturen;

// VorhersageDerEndwerteNachVerschiedenenSchleifen
//Vorhersage der Endwerte nach verschiedenen Schleifen
public class VEVS {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            a += i;
        }
        // sollte a = 0 +1....+9 =45
        System.out.println("a ist " + a);

        int b = 0;
        for (b = 0; b < 10; b++) {
            b += b;
        }
        System.out.println("b ist " + b);
        // Erste Iteration:
        // b = 0
        // b += b ist gleich b = b + b, daher bleibt b 0
        // b++ erhöht b um 1, also wird b zu 1
        // Zweite Iteration:
        // b = 1
        // b += b, daher wird b zu 1 + 1 = 2
        // b++ erhöht b um 1, also wird b zu 3
        // Dritte Iteration:
        // b = 3
        // b += b, daher wird b zu 3 + 3 = 6
        // b++ erhöht b um 1, also wird b zu 7
        // Vierte Iteration:
        // b = 7
        // b += b, daher wird b zu 7 + 7 = 14
        // b++ erhöht b um 1, also wird b zu 15
        // Wenn b 15 wird, ist die Bedingung b < 10 nicht mehr erfüllt,

        int c = 0;
        for (int i = 0; i < 10; i++) {
            c += c++;
        }
        // sollte c = 0 +0 +.....+0 = 0
        System.out.println("c ist " + c);

        int n = 123456789;
        int m = 0;
        while (n != 0) {
            m = (10 * m) + (n % 10);
            n = n / 10;
        }

        System.out.println(" m ist " + m + " n ist " + n);
        // Initialisierung:
        // n wird auf 123456789 gesetzt.
        // m wird auf 0 gesetzt.
        // Schleife (while (n != 0)):

        // Die Schleife wird ausgeführt, solange n nicht 0 ist.
        // Erste Iteration:
        // n % 10 ergibt 9 (die letzte Ziffer von n).
        // m wird aktualisiert zu 10 * m + (n % 10), also 10 * 0 + 9 = 9.
        // n wird aktualisiert zu n / 10, also 123456789 / 10 = 12345678
        // (Ganzzahldivision).
        // Zweite Iteration:
        // n % 10 ergibt 8.
        // m wird aktualisiert zu 10 * m + (n % 10), also 10 * 9 + 8 = 98.
        // n wird aktualisiert zu 12345678 / 10 = 1234567.
        // Dritte Iteration:
        // n % 10 ergibt 7.
        // m wird aktualisiert zu 10 * m + (n % 10), also 10 * 98 + 7 = 987.
        // n wird aktualisiert zu 1234567 / 10 = 123456.
    }
}
