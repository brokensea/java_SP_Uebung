package DAY20_22_7_2024.javaMethoden;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    private final String[] woerterPool = {
            "Flammenschein",
            "Zirkuswagen",
            "Nebelspinne"
    };

    private int count;
    private int maxVersuchenAnzahl;
    private List<Character> falseVersuchtBuchstaben;
    private List<Character> aktuellVersuchtState;
    private String aktuellesWort;
    private Scanner scannerInput;

    public Hangman(Scanner scannerInput) {
        this.scannerInput = scannerInput;
        int i = (int) (Math.random() * woerterPool.length);
        this.aktuellesWort = woerterPool[i];
        this.count = 0;
        this.maxVersuchenAnzahl = aktuellesWort.length() + 2;
        this.falseVersuchtBuchstaben = new ArrayList<>();
        this.aktuellVersuchtState = new ArrayList<>();
        this.initWorte();
    }

    public String getAktuellesWort() {
        return aktuellesWort;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int addCount() {
        return ++count;
    }

    public int getMaxVersuchenAnzahl() {
        return maxVersuchenAnzahl;
    }

    public List<Character> getFalseVersuchtBuchstaben() {
        return falseVersuchtBuchstaben;
    }

    public List<Character> getAktuellVersuchtState() {
        return aktuellVersuchtState;
    }

    private void initWorte() {
        for (int i = 0; i < this.aktuellesWort.length(); i++) {
            aktuellVersuchtState.add('_');
        }
    }

    public void pruefenWorte(char input) {
        boolean found = false;
        for (int i = 0; i < aktuellesWort.length(); i++) {
            if (aktuellesWort.charAt(i) == input) {
                aktuellVersuchtState.set(i, input);
                found = true;
            }
        }
        if (!found) {
            falseVersuchtBuchstaben.add(input);
            addCount();
        }
    }

    public void displayAktuellVersuchtState() {
        for (Character c : aktuellVersuchtState) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void displayFalseVersuchtBuchstaben() {
        System.out.println("Falsche Versuche: " + falseVersuchtBuchstaben);
    }

    public void displayCount() {
        System.out.println("Verbleibende Versuche: " + (maxVersuchenAnzahl - count));
    }

    public boolean pruefenObGewinnen() {
        if (!this.getAktuellVersuchtState().contains('_')) {
            System.out.println("Sie haben das Wort erraten: " + this.getAktuellesWort());
            return true;
        }
        return false;
    }

    public boolean pruefenObVerliert() {
        if (this.getCount() >= this.getMaxVersuchenAnzahl()) {
            System.out.println(
                    "Sie haben die maximale Anzahl an Versuchen erreicht. Das Wort war: " + this.getAktuellesWort());
            return true;
        }
        return false;
    }

    public void run() {
        while (this.getCount() < this.getMaxVersuchenAnzahl()) {
            try {
                System.out.println("Geben Sie einen Buchstaben ein:");
                char input = scannerInput.next().charAt(0);
                this.pruefenWorte(input);
                this.displayFalseVersuchtBuchstaben();
                this.displayAktuellVersuchtState();
                this.displayCount();
                if (this.pruefenObGewinnen()) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }
        if (this.pruefenObVerliert()) {
        }
    }
}
