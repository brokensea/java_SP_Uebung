package DAY5_28_6_2024.javaMethoden;

import java.util.Random;
import java.util.Scanner;

// ### Ziel:

// Entwickle ein einfaches Konsolen-basiertes Spiel in Java,das"Schere-Stein-Papier"simuliert.Der Spieler tritt gegen den Computer an,der zufällig eine Wahl trifft.Das Spiel läuft in einer Schleife,bis der Spieler sich entscheidet,das Spiel zu beenden.

// 1.**Benutzereingabe**:-Der Benutzer soll die Wahl zwischen Schere,Stein und Papier treffen können.-Zusätzlich soll der Benutzer die Möglichkeit haben,das Spiel zu beenden.
// 2.**Computerwahl**:-Der Computer trifft seine Wahl zufällig.
// 3.**Spielregeln**:-Schere schlägt Papier-Papier schlägt Stein-Stein schlägt Schere-Bei gleicher Wahl von Spieler und Computer endet die Runde unentschieden.
// 4.**Spielablauf**:-Das Programm fordert den Benutzer auf,eine Wahl zu treffen(0 für Schere,1 für Stein,2 für Papier,3 zum Beenden).-Die Wahl des Benutzers und die zufällige Wahl des Computers werden angezeigt.-Das Ergebnis der Runde wird basierend auf den Spielregeln ermittelt und angezeigt.-Das Spiel läuft in einer Schleife,bis der Benutzer sich entscheidet,das Spiel zu beenden(Eingabe 3).

public class SchereSteinPapier {

    public static void main(String[] args) {
        SchereSteinPapier schereSteinPapier = new SchereSteinPapier();
        schereSteinPapier.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean weiterspielen = true;

        try {
            while (weiterspielen) {
                System.out.print("Bitte geben Sie eine Zahl von 0 bis 3 ein: ");
                int benutzerWahl = scanner.nextInt();
                while (benutzerWahl < 0 || benutzerWahl > 3) {
                    System.out.print("Ungültige Eingabe. Bitte geben Sie eine Zahl von 0 bis 3 ein: ");
                    benutzerWahl = scanner.nextInt();
                }

                int pcWahl = random.nextInt(4);

                TeilNahmer benutzer = new TeilNahmer("T1", benutzerWahl);
                TeilNahmer pc = new TeilNahmer("PC", pcWahl);
                System.out.println("PC wählt: " + pcWahl + " (" + pc.getWahlString() + ")");

                weiterspielen = vergleichenSchereSteinPapier(benutzer, pc);
            }
        } finally {
            scanner.close();
        }
    }

    private boolean vergleichenSchereSteinPapier(TeilNahmer benutzer, TeilNahmer pc) {
        int benutzerWahl = benutzer.getWahl();
        int pcWahl = pc.getWahl();

        benutzer.setGewinnen(false);
        pc.setGewinnen(false);

        if (benutzerWahl == pcWahl) {
            System.out.println("Unentschieden! Bitte nochmal spielen.");
            benutzer.beschreibenErgebnisse();
            pc.beschreibenErgebnisse();
            return true;
        }
        switch (benutzerWahl) {
            case 0 -> {
                if (pcWahl == 1 || pcWahl == 3) {
                    pc.setGewinnen(true);
                } else {
                    benutzer.setGewinnen(true);
                }
            }
            case 1 -> {
                if (pcWahl == 2 || pcWahl == 3) {
                    pc.setGewinnen(true);
                } else {
                    benutzer.setGewinnen(true);
                }
            }
            case 2 -> {
                if (pcWahl == 0 || pcWahl == 3) {
                    pc.setGewinnen(true);
                } else {
                    benutzer.setGewinnen(true);
                }
            }
            case 3 -> {
                if (pcWahl == 0 || pcWahl == 2) {
                    pc.setGewinnen(true);
                } else {
                    benutzer.setGewinnen(true);
                }
            }
        }

        benutzer.beschreibenErgebnisse();
        pc.beschreibenErgebnisse();
        return false;
    }
}

class TeilNahmer {
    private String name;
    private int wahl;
    private boolean gewinnen;
    private String wahlString;

    public TeilNahmer(String name, int wahl) {
        this.name = name;
        this.wahl = wahl;
        this.wahlIntToString();
    }

    public String getWahlString() {
        return wahlString;
    }

    public String getName() {
        return name;
    }

    public int getWahl() {
        return wahl;
    }

    public boolean isGewinnen() {
        return gewinnen;
    }

    public void setGewinnen(boolean gewinnen) {
        this.gewinnen = gewinnen;
    }

    private void wahlIntToString() {
        switch (this.wahl) {
            case 0 -> this.wahlString = "Schere";
            case 1 -> this.wahlString = "Stein";
            case 2 -> this.wahlString = "Papier";
            case 3 -> this.wahlString = "Eidechse";
            default -> this.wahlString = "Ungültige Wahl";
        }
    }

    public void beschreibenErgebnisse() {
        System.out.println(name + " wählt " + wahlString + " und hat " + (gewinnen ? "gewonnen" : "verloren"));
    }
}
