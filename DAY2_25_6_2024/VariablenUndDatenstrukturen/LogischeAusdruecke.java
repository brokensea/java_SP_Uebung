package DAY2_25_6_2024.VariablenUndDatenstrukturen;

public class LogischeAusdruecke {
    public static void main(String[] args) {
        LogischeAusdruecke logischeAusdruecke = new LogischeAusdruecke();
        logischeAusdruecke.aufgabeRechnen();
    }

    private void aufgabeRechnen() {
        // Überprüfe, ob eine Zahl zwischen 10 und 20 liegt
        int zahl = 15;
        if (zahl >= 10 && zahl <= 20) {
            System.out.println(zahl + "10 <= zahl <= 20 is true");
        } else {
            System.out.println(zahl + " 10 <= zahl <= 20 is false");
        }

        // Bestimme, ob eine Person entweder zwischen 18 und 25 Jahren alt ist oder
        // älter als 65 Jahre

        int alt = 66;
        if (alt >= 18 && zahl <= 25) {
            System.out.println(alt + " 18 <= alt <= 25 is true");
        } else if (alt > 65) {
            System.out.println(alt + " alt > 65 is true");
        }

        // 3. Schreibe einen Ausdruck, der wahr ist, wenn mindestens zwei von drei
        // Zahlen positiv sind
        int count = 0;
        boolean[] arrBoolean = { false, true, false };
        for (boolean arr : arrBoolean) {
            if (arr) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("boolean[] arrBoolean = { false, true, false };"
                    + " wahr, mindestens zwei von drei Zahlen sind positiv ");
        } else {
            System.out.println("boolean[] arrBoolean = { false, true, false };"
                    + "nicht wahr, mindestens zwei von drei Zahlen sind positiv ");
        }

        // Schreibe einen Ausdruck, der wahr ist, wenn eine Zahl weder durch 2 noch
        // durch 3 teilbar ist
        int zahlTeilbar = 6;
        if (!(zahlTeilbar % 2 == 0 || zahlTeilbar % 3 == 0)) {
            System.out.print(zahlTeilbar + "weder durch 2 noch durch 3 teilbar ist");
        } else {
            System.out.println(zahlTeilbar + " ist durch 2 oder durch 3 teilbar.");
        }

        // ) a, b und c sind alle 0
        int a = 1;
        int b = 0;
        int c = 0;
        if (a == 0 && b == 0 && c == 0) {
            System.out.println(a + " " + b + " " + c + " abc sind 0 ");
        } else {
            System.out.println(a + " " + b + " " + c + " abc sind nicht 0");
        }

        // ) a, b und c haben den gleichen Wert
        a = 2;
        b = 2;
        c = 2;
        if (a == b && b == c) {
            System.out.println(a + " " + b + " " + c + " abc haben den gleichen Wert");
        } else {
            System.out.println(a + " " + b + " " + c + " abc haben keinen gleichen Wert");
        }

        // genau eines von a, b und c ist falsch
        int count2 = 0;
        boolean a2 = true;
        boolean b2 = true;
        boolean c2 = false;
        boolean[] arrBoolean2 = { a2, b2, c2 };
        for (boolean arr : arrBoolean2) {
            if (!arr) {
                count2++;
            }
        }
        if (count2 == 1) {
            System.out.println(" " + a2 + " " + b2 + " " + c2 + " genau eines von a, b und c ist falsch ");
        } else {
            System.out.println(" " + a2 + " " + b2 + " " + c2 + "nicht genau eines von a, b und c ist falsch ");
        }

        // ) a ist ein Vielfaches von 2 und 7 oder ein Vielfaches von 7 und 11
        int aZahl = 14;
        if ((aZahl % 2 == 0 && aZahl % 7 == 0) || (aZahl % 7 == 0 && aZahl % 11 == 0)) {
            System.out.println(aZahl + " ist ein Vielfaches von 2 und 7 oder ein Vielfaches von 7 und 11");
        } else {
            System.out.println(aZahl + " ist nicht ein Vielfaches von 2 und 7 oder ein Vielfaches von 7 und 11");
        }

        // ) a, b und c sind alle drei true oder alle drei false
        boolean a3 = true;
        boolean b3 = true;
        boolean c3 = true;
        if (a3 == b3 && b3 == c3) {
            System.out.println("a, b und c sind alle drei true oder alle drei false");
        } else {
            System.out.println("a, b und c sind nicht alle drei true oder alle drei false");
        }

    }
}
