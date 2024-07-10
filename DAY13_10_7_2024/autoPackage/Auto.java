package DAY13_10_7_2024.autoPackage;

import java.lang.reflect.Parameter;

// ##Klasse Auto

// -Erstelle eine Klasse Auto mit folgenden Attributen:-**`marke`**-**`baujahr`**-**`kilometerstand`**

// →Wähle passende Datentypen für die Attribute.

// -Erstelle Konstruktor,der die Parameter Marke,Baujahr und Kilometerstand akzeptiert-Erstelle Getter&Setter für die Attribute-Füge der Auto-Klasse eine Methode getDetails hinzu,die alle Eigenschaften des Autos in einer übersichtlichen Form ausgibt.,
//##Klasse Fahrer

// -Erstelle eine separate Klasse Fahrer mit folgenden Eigenschaften:-**`vorname`**-**`nachname`**-**`alter`**

// →Wähle passende Datentypen für die Attribute.

// -Implementiere eine Methode**`fahren(Auto auto,int kilometer)`**,die einen Fahrer ein Auto für eine bestimmte Kilometeranzahl fahren lässt.Erhöhe den Kilometerstand des Autos um den übergebenen Wert.Überprüfe,ob der übergebene Wert negativ ist,was einen Fehler werfen soll.Überprüfe außerdem,ob der Fahrer über 18 ist.

// **Zu guter Letzt sollst du eine Main-Methode erstellen,die deine Klassen Auto und Fahrer mit den dazugehörigen Methoden benutzt.**

public class Auto {
    private String marke;
    private int baujahr;
    private int kilometerstand;

    // 2 Neue Felder
    private String modell;
    private double tankkapazitaet;
    private double tankinhalt;
    private double verbrauch;

    public Auto(String marke, String modell, int baujahr) {
        this.marke = marke;
        this.baujahr = baujahr;
        this.modell = modell;

        this.kilometerstand = 0;
        this.tankkapazitaet = 50.0;
        this.tankinhalt = 0.0;
        this.verbrauch = 0.7;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public double getTankkapazitaet() {
        return tankkapazitaet;
    }

    public void setTankkapazitaet(double tankkapazitaet) {
        this.tankkapazitaet = tankkapazitaet;
    }

    public double getTankinhalt() {
        return tankinhalt;
    }

    public void setTankinhalt(double tankinhalt) {
        this.tankinhalt = tankinhalt;
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(double verbrauch) {
        this.verbrauch = verbrauch;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public double getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }

    public void addKilometerstand(int kilometer) {
        this.kilometerstand += kilometer;
    }

    // 2
    // Methode zum Tanken
    public boolean tanken(double liter) {
        if (this.getTankinhalt() + liter > this.getTankkapazitaet()) {
            throw new IllegalArgumentException("Tankinhalt größer als Tankkapazität");
        } else {
            this.tankinhalt += liter;
            return true;
        }
    }

    // Methode zur Überprüfung des Service
    public boolean pruefeService() {
        if (this.kilometerstand > 15000) {
            throw new IllegalStateException("Kilometerstand mehr als 15000");
        } else {
            System.out.println(this.marke + " funktioniert noch");
            return true;
        }
    }

    // Methode zur Berechnung der Reichweite
    public int reichweiteBerechnen() {
        int reichweite = (int) (this.tankinhalt / this.verbrauch);
        System.out.println("Reichweite ist " + reichweite + " KM");
        return reichweite;
    }

    // toString Methode
    @Override
    public String toString() {
        return "Auto{" +
                "marke='" + marke + '\'' +
                ", modell='" + modell + '\'' +
                ", baujahr=" + baujahr +
                ", kilometerstand=" + kilometerstand +
                ", tankkapazitaet=" + tankkapazitaet +
                ", tankinhalt=" + tankinhalt +
                ", verbrauch=" + verbrauch +
                '}';
    }

    // Methode zum Anzeigen der Details
    public void getDetails() {
        System.out.println(this.toString());
    }

}

// auto 2
// **In dieser Aufgabe geht es um das Tanken und die Reichweite unseres Autos
// 🏁**

// - Füge der Klasse Auto die folgenden Attribute hinzu:
// - **`tankkapazitaet`**: ein double Attribut, das die maximale Tankkapazität
// des Autos in Litern repräsentiert
// - **`tankinhalt`**: ein double Attribut, das den aktuellen Tankinhalt des
// Autos in Litern repräsentiert
// - **`verbrauch:`** ein double Attribut, das den Literverbrauch pro Kilometer
// speichert
// - dein Konstruktor soll weiterhin nur die Marke, das Modell und das Baujahr
// als Parameter akzeptiert und die anderen Attribute auf Standardwerte setzt
// (Kilometerstand auf 0, Tankinhalt auf 0.0, und Tankkapazität auf 50.0)

// **Erweitere deine Methode`fahren(Auto auto, int kilometer)`:**

// - verringere den Tankinhalt entsprechend

// dem Verbrauch (angenommen, das Auto verbraucht 0.07 Liter pro Kilometer)
// - gib eine Fehlermeldung aus, wenn der Tankinhalt nicht ausreicht

// **

// Implementiere außerdem
// folgende Methoden:**

// -**`tanken(double liter)`**: erhöhe den Tankinhalt um den übergebenen Wert,
// jedoch nicht über die maximale Tankkapazität hinaus. Gib eine Fehlermeldung
// aus, wenn der Tankinhalt über die maximale Kapazität hinaus gehen würde
// - **`pruefeService()`**: gib eine Meldung aus, dass ein Service erforderlich
// ist, wenn der Kilometerstand 15.000 Kilometer überschreitet
// - Implementiere eine Methode **`reichweiteBerechnen` ,** die die Reichweite
// des Autos basierend auf dem aktuellen Tankinhalt und dem durchschnittlichen
// Verbrauch pro Kilometer berechnet