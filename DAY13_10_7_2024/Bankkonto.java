package DAY13_10_7_2024;

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

}
