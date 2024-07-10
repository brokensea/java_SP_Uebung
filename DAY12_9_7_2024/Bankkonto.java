package DAY12_9_7_2024;

import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
// import java.time.LocalDateTime;
// import java.time.Year;
import java.util.ArrayList;

// Implementiere eine Java-Klasse namens**`Bankkonto`**,die die folgenden Attribute hat:

// -**`kontoinhaber`**(String):Der Name des Kontoinhabers-**`kontonummer`**(String):Die Kontonummer des Bankkontos-**`kontostand`**(double):Der aktuelle Kontostand

// Die Klasse soll einen Konstruktor haben,der den Namen des Kontoinhabers und die Kontonummer als Parameter akzeptiert und den Kontostand auf 0.0 setzt.

// Implementiere außerdem folgende Methoden:

// -Getter&Setter für alle Attribute-**`einzahlen(double betrag)`**:Erhöht den Kontostand um den übergebenen Betrag-**`abheben(double betrag)`**:Verringert den Kontostand um den übergebenen Betrag,wenn ausreichend Guthaben vorhanden ist-**`gibKontoinformationen()`**:Gibt die Kontoinformationen(Kontoinhaber,Kontonummer und Kontostand)auf der Konsole aus

// Schreibe dann eine separate Klasse,die die**`main`**-Methode enthält.In dieser Methode sollst du ein Objekt der Klasse**`Bankkonto`**erstellen und mehrere Einzahlungs-und Auszahlungsvorgänge ausführen.Gib nach jeder Aktion die aktuellen Kontoinformationen aus.Teste insbesondere auch den Fall,wenn versucht wird,mehr Geld abzuheben,als auf dem Konto vorhanden ist.

public class Bankkonto {
    private String kontoinhaber;
    private String kontonummer;
    private double kontostand;
    private ArrayList<Transaktion> transaktionshistorien;
    // kann mann mit Array mit clone machen;

    public Bankkonto(String kontoinhaber, String kontonummer) {
        this.setKontoinhaber(kontoinhaber);
        this.setKontonummer(kontonummer);
        this.setKontostand(0.0);
        this.transaktionshistorien = new ArrayList<>();
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(String kontonummer) {
        this.kontonummer = kontonummer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    // einzahlen(double betrag): Erhöht den Kontostand um den übergebenen Betrag
    public boolean einzahlen(double betrag) {
        if (betrag > 0) {
            this.kontostand += betrag;
            Transaktion tr = new Transaktion(Transaktionstyp.Einzahlung, betrag);
            transaktionshistorien.add(tr);
            return true;
        }
        System.out.println("Unzureichender Betrag, fehlgeschlagen");
        return false;
    }

    // abheben(double betrag): Verringert den Kontostand um den übergebenen Betrag,
    // wenn ausreichend Guthaben vorhanden ist
    public boolean abheben(double betrag) {
        if (betrag > this.kontostand) {
            System.out.println("Unzureichender Kontostand, fehlgeschlagen");
            return false;
        }
        Transaktion tr = new Transaktion(Transaktionstyp.Abhebung, betrag);
        transaktionshistorien.add(tr);
        this.kontostand -= betrag;
        return true;
    }

    // gibKontoinformationen(): Gibt die Kontoinformationen (Kontoinhaber,
    // Kontonummer und Kontostand) auf der Konsole aus
    public void gibKontoinformationen() {
        System.out.println(this.toString());
    }

    public boolean ueberweisen(Bankkonto empfaenger, double betrag) {
        if (this.abheben(betrag) && empfaenger.einzahlen(betrag)) {
            System.out.println(empfaenger.kontoinhaber + " erhält " + betrag + " von " + this.kontoinhaber);
            return true;
        } else {
            System.out.println(empfaenger.kontoinhaber + " erhält NICHT " + betrag + " von " + this.kontoinhaber);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Bankkonto{" +
                "kontoinhaber='" + kontoinhaber + '\'' +
                ", kontonummer='" + kontonummer + '\'' +
                ", kontostand=" + kontostand +
                '}';
    }

    public void printTransaktionshistorien() {
        System.out.println();
        System.out.println("Transaktionshistorien von " + this.kontoinhaber + "ist: ");
        for (Transaktion aTransaktion : this.transaktionshistorien) {
            System.out.println(aTransaktion.toString());
        }
    }

    enum Transaktionstyp {
        Einzahlung,
        Abhebung,
        Ueberweisung
    }

    private class Transaktion {
        private Transaktionstyp transaktionstyp;
        private double betrag;
        private LocalDate date;
        private LocalTime time;

        public Transaktion(Transaktionstyp transaktionstyp, double betrag) {
            this.transaktionstyp = transaktionstyp;
            this.betrag = betrag;
            this.date = LocalDate.now();
            this.time = LocalTime.now();
        }

        @Override
        public String toString() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            return "Transaktion{" +
                    "transaktionstyp=" + transaktionstyp +
                    ", betrag=" + betrag +
                    ", date=" + date.format(dateFormatter) +
                    ", time=" + time.format(timeFormatter) +
                    '}';
        }

    }

}
