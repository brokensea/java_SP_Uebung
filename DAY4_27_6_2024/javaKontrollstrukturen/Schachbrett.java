package DAY4_27_6_2024.javaKontrollstrukturen;

// Schreibe ein Java-Programm,das ein Schachbrettmuster in der Konsole ausgibt.Die Größe vom Schachbrett soll der Benutzer beim Programmaufruf mitgeben.Ein Schachbrett besteht aus abwechselnden Zeichen"#"und" ",wobei die oberen linken Ecke immer eine"#"ist.

public class Schachbrett {

    public static void main(String[] args) {
        Schachbrett schachbrett = new Schachbrett();
        schachbrett.drawSchachbrett(8);
    }

    private boolean drawSchachbrett(int hoch) {
        if (hoch <= 0) {
            System.out.println("Muss int größer als 0");
            return false;
        }
        int numInsgesamt = hoch * hoch;
        int anZahl = 1;
        while (anZahl <= numInsgesamt) {
            int anZahlZeile = 1;
            while (anZahlZeile <= hoch) {
                if (anZahl % 2 != 0) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
                anZahlZeile++;
                anZahl++;
            }
            System.out.println();
            anZahl++;
        }
        return true;
    }

}
