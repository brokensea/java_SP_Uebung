package DAY6_1_7_2024.javaMethoden;

import java.util.Random;
import java.util.Scanner;

// ### Ziel:

// Deshalb sollst du dein bestehendes"Schere, Stein, Papier"-Spiel um eine Funktionalität zur Punktezählung ergänzen.Die Punktezahl des Spielers und des Computers soll gezählt und nach jeder Runde sowie am Ende des Spiels angezeigt werden.

// **Bonus:**

// Wenn der Spieler oder der Computer dreimal hintereinander gewinnt,erhält der jeweilige Gewinner einen zusätzlichen Punkt.Gebe nach einer Runde,in der ein Bonuspunkt vergeben wurde,eine entsprechende Nachricht aus.

public class SchereSteinPapier {
    final int SCHERE = 0;
    final int STEIN = 1;
    final int PAPIER = 2;
    final int EXIT = 3;

    private TeilNahmer benutzer;
    private TeilNahmer pc;

    public static void main(String[] args) {
        SchereSteinPapier schereSteinPapier = new SchereSteinPapier();
        schereSteinPapier.run();

        // TeilNahmer teilTest = new TeilNahmer("test");
        // teilTest.setZahlHintereinanderGewinnen(2); // 设置为 2，准备测试第三次赢的情况
        // teilTest.setGewinnen(true); // 第三次赢
        // teilTest.beschreibenErgebnisse();

    }

    private void fin1Gewinnen() {
        if (this.pc.getPunkt() == this.benutzer.getPunkt()) {
            System.out.println("Kein Gewinner");
        } else if (this.pc.getPunkt() > this.benutzer.getPunkt()) {
            System.out.println("Punkt: " + this.pc.getPunkt() + " PC Gewinner");
        } else {
            System.out.println("Punkt: " + this.benutzer.getPunkt() + " Benutzer Gewinner");
        }
    }

    private void run() {
        benutzer = new TeilNahmer("Benutzer");
        pc = new TeilNahmer("PC");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        try {
            while (true) {
                System.out.print("Bitte geben Sie eine Zahl von 0 bis 3 ein: ");

                boolean istUngueltig = true;
                int benutzerWahl;
                do {
                    benutzerWahl = scanner.nextInt();
                    if (benutzerWahl == EXIT) {
                        if (this.pc.getPunkt() != 0 && this.benutzer.getPunkt() != 0) {
                            this.fin1Gewinnen();
                        }
                        System.out.println("3 eingeben: Ausfahrt");
                        return;
                    }

                    if (benutzerWahl < 0 || benutzerWahl > 2) {
                        System.out.print("Ungültige Eingabe. Bitte geben Sie eine Zahl von 0 bis 2 ein: ");
                        continue;
                    }
                    istUngueltig = false;
                } while (istUngueltig);

                // int pcWahl = STEIN;
                int pcWahl = random.nextInt(3);
                benutzer.setWahl(benutzerWahl);
                pc.setWahl(pcWahl);

                System.out.println("PC wählt: " + pcWahl + " (" + pc.getWahlString() + ")");
                vergleichenSchereSteinPapier(benutzer, pc);

                // Increment round after processing both participants
                benutzer.incrementRound();
                pc.incrementRound();
            }
        } finally {
            scanner.close();
        }
    }

    private void vergleichenSchereSteinPapier(TeilNahmer benutzer, TeilNahmer pc) {
        int benutzerWahl = benutzer.getWahl();
        int pcWahl = pc.getWahl();

        // benutzer.setGewinnen(false);
        // pc.setGewinnen(false);

        if (benutzerWahl == pcWahl) {
            System.out.println("Unentschieden! Bitte nochmal spielen.");
            benutzer.beschreibenErgebnisse();
            pc.beschreibenErgebnisse();
            return;
        }

        switch (benutzerWahl) {
            case SCHERE -> {
                if (pcWahl == STEIN) {
                    pc.setGewinnen(true);
                } else {
                    benutzer.setGewinnen(true);
                }
            }
            case STEIN -> {
                if (pcWahl == PAPIER) {
                    pc.setGewinnen(true);
                } else {
                    benutzer.setGewinnen(true);
                }
            }
            case PAPIER -> {
                if (pcWahl == SCHERE) {
                    pc.setGewinnen(true);
                } else {
                    benutzer.setGewinnen(true);
                }
            }
        }

        benutzer.beschreibenErgebnisse();
        pc.beschreibenErgebnisse();
    }

}

class TeilNahmer {

    private String name;
    private int wahl;
    private boolean gewinnen;
    private String wahlString;
    private int punkt = 0;
    private int runde = 1;
    private int zahlHintereinanderGewinnen = 0;

    public int getZahlHintereinanderGewinnen() {
        return zahlHintereinanderGewinnen;
    }

    public void setZahlHintereinanderGewinnen(int zahlHintereinanderGewinnen) {
        this.zahlHintereinanderGewinnen = zahlHintereinanderGewinnen;
    }

    public void incrementzahlHintereinanderGewinnen() {
        this.zahlHintereinanderGewinnen++;
    }

    public int getPunkt() {
        return punkt;
    }

    public void setPunkt(int punkt) {
        this.punkt = punkt;
    }

    public TeilNahmer(String name) {
        this.name = name;
    }

    public int getWahl() {
        return wahl;
    }

    public void setWahl(int wahl) {
        this.wahl = wahl;
        this.wahlIntToString();
    }

    public String getWahlString() {
        return wahlString;
    }

    public void setGewinnen(boolean gewinnen) {
        if (gewinnen) {
            this.punkt += 100;
            this.zahlHintereinanderGewinnen++;
            if (this.zahlHintereinanderGewinnen == 3) {
                System.out.println(this.name + " erhält 200 Bonuspunkte für drei aufeinanderfolgende Siege!");
                this.punkt += 200;
                this.zahlHintereinanderGewinnen = 0;
            }
        } else {
            this.zahlHintereinanderGewinnen = 0;
        }
    }

    public void incrementRound() {
        this.runde++;
    }

    private void wahlIntToString() {
        switch (this.wahl) {
            case 0 -> this.wahlString = "Schere";
            case 1 -> this.wahlString = "Stein";
            case 2 -> this.wahlString = "Papier";
            default -> this.wahlString = "Ungültige Wahl";
        }
    }

    public void beschreibenErgebnisse() {
        // System.out.println(this.name + "zahl" + this.zahlHintereinanderGewinnen);

        System.out.print(this.runde);
        System.out.println(
                name + " wählt " + wahlString + " und hat in dieser Runde " + (gewinnen ? "gewonnen" : "verloren"));
        System.out.println();
        System.out.println("Runde: " + this.runde + ", Name: " + this.name + " Punkt: " + this.punkt);
    }
}