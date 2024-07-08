package DAY11_8_7_2024.javaOOP.uebung;

// **Klasse Übungsblatt erstellen:**

// -schreibe eine Klasse**Übungsblatt**,die drei ganze Zahlen als Attribute hat:die Nummer des Übungsblattes,die maximale Anzahl an Punkten und die erreichte Anzahl an Punkten-die Klasse soll einen Konstruktor haben,dem diese drei ganze Zahlen übergeben werden-achte darauf,dass alle drei Attribute auch außerhalb der Klasse Übungsblatt zugreifbar sind.Verwende dafür Getter-und Setter-Methoden

// **Erstellung und Initialisierung von Übungsblättern:**

// -schreibe eine Klasse Rechner,die eine main Methode enthält-in der main Methode sollen 13 Übungsblätter erstellt und in einem Array abgelegt werden-die Übungsblätter sollen aufsteigende Nummern ab 1 haben-jedes Übungsblatt soll eine maximale Punktzahl von 60 haben-die erreichte Punktzahl jedes Übungsblattes soll eine Zufallszahl zwischen 0 und 60 sein

// ###✨ Bonus✨

// **Ausgabe der Ergebnisse und Überprüfung der Klausurzulassungsgrenze:**

// -Gib die Gesamtzahl der maximal erreichbaren Punkte und der erreichten Punkte aus-Gib den prozentualen Anteil der erreichten Punkte aus-Überprüfe,ob die Klausurzulassungsgrenze von 50%erreicht wurde und gib das Ergebnis entsprechend aus

// **Ermittlung der besten und schlechtesten Übungsblätter:**

// -Implementiere in der Klasse`Übungsblatt`eine Methoden,um das Übungsblatt mit der höchsten und das mit der niedrigsten erreichten Punktzahl zu ermitteln und auszugeben

public class Uebungsblatt {

    private int nummerUebungsblatt;
    private int maximalePunkten;
    private int erreichtePunkten;

    public Uebungsblatt(int nummerUebungsblatt, int maximalePunkten, int erreichtePunkten) {
        this.setNummerUebungsblatt(nummerUebungsblatt);
        this.setMaximalePunkten(maximalePunkten);
        this.setErreichtePunkten(erreichtePunkten);
    }

    public int getNummerUebungsblatt() {
        return nummerUebungsblatt;
    }

    public void setNummerUebungsblatt(int nummerUebungsblatt) {
        this.nummerUebungsblatt = nummerUebungsblatt;
    }

    public int getMaximalePunkten() {
        return maximalePunkten;
    }

    public void setMaximalePunkten(int maximalePunkten) {
        if (0 > maximalePunkten || maximalePunkten > 60) {
            throw new IllegalArgumentException("IllegalArgumentException");

        }
        this.maximalePunkten = maximalePunkten;
    }

    public int getErreichtePunkten() {
        return erreichtePunkten;
    }

    public void setErreichtePunkten(int erreichtePunkten) {
        if (0 > erreichtePunkten || erreichtePunkten > maximalePunkten) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        this.erreichtePunkten = erreichtePunkten;
    }

    @Override
    public String toString() {
        return "Uebungsblatt{" +
                "nummerUebungsblatt=" + nummerUebungsblatt +
                ", maximalePunkten=" + maximalePunkten +
                ", erreichtePunkten=" + erreichtePunkten +
                '}';
    }

    private boolean ueberpruefe() {
        boolean out;
        if ((double) erreichtePunkten / (double) maximalePunkten >= 0.5) {
            out = true;
            System.out.println("bestanden ture or fals: " + out + " ");
            return out;
        }
        out = false;
        System.out.println("bestanden ture or fals: " + out + " ");
        return out;
    }

    public void printDetails() {
        System.out.println(this.toString());
        ueberpruefe();
    }

    public boolean istHoechstesBlatt(Uebungsblatt vergleichsBlatt) {
        return this.erreichtePunkten > vergleichsBlatt.getErreichtePunkten();
    }

    public boolean istNiedrigstesBlatt(Uebungsblatt vergleichsBlatt) {
        return this.erreichtePunkten < vergleichsBlatt.getErreichtePunkten();
    }
}
