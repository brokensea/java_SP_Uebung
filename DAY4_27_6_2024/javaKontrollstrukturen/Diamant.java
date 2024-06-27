package DAY4_27_6_2024.javaKontrollstrukturen;

// Schreibe ein Programm,welches Diamanten in Form von Sternchen(*)in der Konsole ausgibt.Die Größe der Diamanten soll der Benutzer beim Programmaufruf mitgeben.

// Tip:Damit die Diamanten eine gute Form haben,muss die Größe ungerade sein.Entscheide dich,ob du aus einer geraden Zahl eine ungerade machen möchtest oder ob du in dem Fall den Nutzer um eine erneute(ungerade)Eingabe bittest.

public class Diamant {
    public static void main(String[] args) {
        Diamant diamant = new Diamant();
        diamant.drawDiamant(9);
        // diamant.drawInvertedPyramid(3);
    }

    private boolean drawDiamant(int hoch) {
        if (hoch % 2 == 0) {
            System.out.println("nur ungerade eingeben");
            return false;
        } else {
            int anzahlOben = hoch / 2 + 1;
            int anzahlUnter = hoch - anzahlOben;
            drawPyramid(anzahlOben);
            drawInvertedPyramid(anzahlUnter);
        }

        return true;
    }

    // Oben Teil
    private void drawPyramid(int hoch) {
        int jetztHoch = 1;
        while (jetztHoch <= hoch) {
            int anzahlLeerzeichen = hoch - jetztHoch;
            int leerzeichenAnzahl = 0;
            while (leerzeichenAnzahl < anzahlLeerzeichen) {
                System.out.print(" ");
                leerzeichenAnzahl++;
            }
            int anzahlSterne = 2 * jetztHoch - 1;
            int sterneAnzahl = 0;
            while (sterneAnzahl < anzahlSterne) {
                System.out.print("*");
                sterneAnzahl++;
            }
            System.out.println();
            jetztHoch++;
        }
    }

    // Unten Teil
    private void drawInvertedPyramid(int hoch) {
        int jetztHoch = hoch;
        while (jetztHoch >= 1) {
            int leerzeichenAnzahl = 0;
            // muss ein Leehrzeichen an Anfang
            System.out.print(" ");
            while (leerzeichenAnzahl < hoch - jetztHoch) {
                System.out.print(" ");
                leerzeichenAnzahl++;
            }

            int sterneAnzahl = 0;
            int anzahlSterne = 2 * jetztHoch - 1;
            while (sterneAnzahl < anzahlSterne) {
                System.out.print("*");
                sterneAnzahl++;
            }
            System.out.println();
            jetztHoch--;
        }
    }
}