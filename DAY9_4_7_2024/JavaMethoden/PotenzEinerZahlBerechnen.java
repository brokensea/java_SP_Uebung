package DAY9_4_7_2024.JavaMethoden;

// Implementiere eine rekursive Methode in Java,die die Potenz einer nicht-negativen ganzen Zahl berechnet.Die Methode soll zwei Parameter akzeptieren:die Basis x und den Exponenten n:

public class PotenzEinerZahlBerechnen {
    public static void main(String[] args) {
        PotenzEinerZahlBerechnen potenzEinerZahlBerechnen = new PotenzEinerZahlBerechnen();
        System.out.println(potenzEinerZahlBerechnen.calculatePowerNumber(2, 4));
    }

    private int calculatePowerNumber(int basis, int exponenten) {
        if (exponenten <= 0) {
            return 1;
        }
        return basis * calculatePowerNumber(basis, exponenten - 1); // -- exponenten Ok
        // exponenten-- verwendet, was bedeutet, dass der aktuelle Wert von exponenten
        // an die rekursive Funktion übergeben wird und erst danach exponenten um 1
        // verringert wird.
    }

}
