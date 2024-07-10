package DAY13_10_7_2024;

// a)Was gibt folgendes Codefragment aus?Erkläre,warum die entsprechende Ausgabe zu Stande kommt.Position p1=new Position(11,21);Position p2=new Position(11,21);

// if(p1==p2){System.out.println("true");}else{System.out.println("false");}

// b)Was gibt folgendes Codefragment aus?Erkläre,warum die entsprechende Ausgabe zu Stande kommt.Position p1=new Position(0,0);Position p2=new Position(0,0);p1=p2;p1.x=21;p2.y=11;p2=p1;System.out.println("p1 -> X: "+p2.x+", Y: "+p2.y);

// c)Was gibt folgendes Codefragment aus?Erkläre,warum die entsprechende Ausgabe zu Stande kommt.

// ```java Position p1=new Position(3,3);Position p2=new Position(6,6);Position p3=p1;

// p1=p2;p2=new Position(9,9);p3.y=12;

// System.out.println("p1 -> X: "+p1.x+", Y: "+p1.y);System.out.println("p2 -> X: "+p2.x+", Y: "+p2.y);System.out.println("p3 -> X: "+p3.x+", Y: "+p3.y);```

public class Objektreferenzen {
    public static void main(String[] args) {

        // a
        Position p1 = new Position(11, 21);
        Position p2 = new Position(11, 21);

        if (p1 == p2) {
            System.out.println("true");
        } else {
            System.out.println("false"); // false
        }
        // weil: == vergleich nur reference kein tiefer vergleichen:
        // Referenzvergleich:

        // Die Bedingung if (p1 == p2) prüft, ob p1 und p2 auf dasselbe Objekt im
        // Speicher verweisen, nicht ob sie denselben Inhalt (in diesem Fall dieselben
        // Koordinaten) haben.
        // p1 und p2 unterschiedliche Objekte mit unterschiedlichen Speicheradressen
        // sind.
        // p1 und p2 unterschiedliche Objekte mit unterschiedlichen Speicheradressen
        // sind.

        // b
        Position p12 = new Position(0, 0);
        Position p22 = new Position(0, 0);
        p12 = p22;
        p12.x = 21;
        p22.y = 11;
        p22 = p12;
        System.out.println("p1 -> X: " + p22.x + ", Y: " + p22.y);
        // x 21, y 0,(false)

        System.out.println("p1 -> X: " + p12.x + ", Y: " + p12.y);
        // weil: p12 = p22; // 1. Referenzzuweisung: p12 und p22 zeigen jetzt auf
        // dasselbe Objekt
        // p12.x = 21; // 2. Änderung von p12.x auf 21 (p12 und p22 zeigen auf dasselbe
        // Objekt, also
        // betrifft dies auch p22)
        // p22.y = 11; // 3. Änderung von p22.y auf 11

        // p22 = p12; // 4. Referenzzuweisung: p22 zeigt jetzt wieder auf dasselbe
        // Objekt wie p12

        // System.out.println("p1 -> X: " + p22.x + ", Y: " + p22.y);
        // Ausgabe: p1 -> X: 21, Y: 11

        // c
        Position p13 = new Position(3, 3);
        Position p23 = new Position(6, 6);
        Position p33 = p13;

        p13 = p23;
        p23 = new Position(9, 9);
        p33.y = 12;

        System.out.println("p13 -> X: " + p13.x + ", Y: " + p13.y); // 6 6
        System.out.println("p23 -> X: " + p23.x + ", Y: " + p23.y); // 9 9
        System.out.println("p33 -> X: " + p33.x + ", Y: " + p33.y); // 3 12

    }
    // weil; Position p13 = new Position(3, 3); // Erstelle ein Position-Objekt mit
    // den Koordinaten (3, 3)
    // Position p23 = new Position(6, 6); // Erstelle ein weiteres Position-Objekt
    // mit den Koordinaten (6, 6)
    // Position p33 = p13; // p33 zeigt jetzt auf dasselbe Objekt wie p13

    // p13=p23; // p13 zeigt jetzt auf dasselbe Objekt wie p23
    // p23=new Position(9,9); // p23 zeigt jetzt auf ein neues Position-Objekt mit
    // den Koordinaten (9, 9)
    // p33.y=12; // Ändere die y-Koordinate des Objekts, auf das p33 zeigt, auf 12

    // System.out.println("p13 -> X: "+p13.x+", Y: "+p13.y); // Ausgabe: p13 -> X:
    // 6, Y: 6
    // System.out.println("p23 -> X: "+p23.x+", Y: "+p23.y); // Ausgabe: p23 -> X:
    // 9, Y: 9
    // System.out.println("p33 -> X: "+p33.x+", Y: "+p33.y); // Ausgabe: p33 -> X:
    // 3, Y: 12
}

/**
 * Position
 */
class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
