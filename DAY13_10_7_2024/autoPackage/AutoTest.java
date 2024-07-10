package DAY13_10_7_2024.autoPackage;

public class AutoTest {

    public static void main(String[] args) {
        initTest();
    }

    public static void initTest() {
        // Erstelle einige Auto-Objekte
        Auto auto1 = new Auto("BMW", "X5", 2020);
        Auto auto2 = new Auto("Audi", "A4", 2018);
        Auto auto3 = new Auto("Mercedes", "C-Class", 2019);

        // Erstelle einige Fahrer-Objekte
        Fahrer fahrer1 = new Fahrer("Max", "mann", 25);
        Fahrer fahrer2 = new Fahrer("Anna", "frau", 30);
        Fahrer fahrer3 = new Fahrer("Tom", "mann", 17);

        // Test 1: Tankkapazität testen
        System.out.println("Test 1: Tankkapazität");
        try {
            auto1.tanken(30);
            auto2.tanken(40);
            auto3.tanken(60); // Exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Ausgabe der Details der Autos nach dem Tanken
        auto1.getDetails();
        auto2.getDetails();
        auto3.getDetails();

        // Test 2: Fahren mit den Autos
        System.out.println("\nTest 2: Fahren");
        try {
            fahrer1.fahren(auto1, 100);
            fahrer2.fahren(auto2, 200);
            // Dieser Test sollte eine Ausnahme werfen, weil der Fahrer zu jung ist
            fahrer3.fahren(auto3, 50);
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Ausgabe der Details der Autos nach dem Fahren
        auto1.getDetails();
        auto2.getDetails();
        auto3.getDetails();

        // Test 3: Reichweite berechnen
        System.out.println("\nTest 3: Reichweite berechnen");
        int reichweite1 = auto1.reichweiteBerechnen();
        int reichweite2 = auto2.reichweiteBerechnen();
        int reichweite3 = auto3.reichweiteBerechnen();
        System.out.println("Reichweite Auto 1: " + reichweite1 + " KM");
        System.out.println("Reichweite Auto 2: " + reichweite2 + " KM");
        System.out.println("Reichweite Auto 3: " + reichweite3 + " KM");

        // Test 4: Serviceprüfung
        System.out.println("\nTest 4: Serviceprüfung");
        try {
            auto1.pruefeService();
            auto2.pruefeService();
            auto3.pruefeService();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
