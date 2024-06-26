package DAY3_26_6_2026.javaKontrollstrukturen;

public class SchleifenUmwandeln {
    public static void main(String[] args) {
        SchleifenUmwandeln schleifenUmwandeln = new SchleifenUmwandeln();

        schleifenUmwandeln.rechnenSumeInForSchleifer();
        schleifenUmwandeln.rechnenSumeInWhileSchleifer();

        schleifenUmwandeln.rechnenInWhileSchleifer();
        schleifenUmwandeln.rechnenInForSchleifer();
    }

    // Wandle folgende For-Schleife in eine While-Schleife um:
    private void rechnenSumeInForSchleifer() {
        int summe = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Durchlauf: " + i);
            summe += i;
        }
        System.out.println(summe);
    }

    private void rechnenSumeInWhileSchleifer() {
        int summe = 0;
        int i = 0;
        while (i < 10) {
            System.out.println("Durchlauf: " + i);
            summe += i;
            i++;
        }
        System.out.println(summe);
    }

    // Wandle folgende Do-While-Schleife in eine For-Schleife um:
    private void rechnenInWhileSchleifer() {
        int a = 0;
        do {
            a += 2;
            System.out.println(a);
        } while (a < 7);

    }

    private void rechnenInForSchleifer() {

        for (int a = 2; a < 7; a += 2) {
            System.out.println("a +" + a);
        }

    }
    // Startwert von a:
    // In der do-while
    // Schleife wird
    // a beim
    // ersten Durchlauf auf 2

    // gesetzt (a += 2). Deshalb setzen wir den Startwert von a in der for Schleife
    // auf 2.
    // Schleifenbedingung: In der do-while Schleife läuft die Schleife, solange a
    // kleiner als 7 ist. Da a in jedem Durchlauf um 2 erhöht wird, muss die for
    // Schleife bis einschließlich 8 laufen, um die gleiche Anzahl von Iterationen
    // zu haben

}
