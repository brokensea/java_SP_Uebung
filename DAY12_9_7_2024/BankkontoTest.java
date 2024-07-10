package DAY12_10_7_2024;

public class BankkontoTest {
    public static void main(String[] args) {
        initTest();
    }

    private static void initTest() {
        Bankkonto konto1 = new Bankkonto("Max C", "123");
        Bankkonto konto2 = new Bankkonto("Erika M", "456");
        Bankkonto konto3 = new Bankkonto("John D", "789");
        Bankkonto konto4 = new Bankkonto("Jane E", "100");
        Bankkonto konto5 = new Bankkonto("Alice A", "200");

        // Einzahlungen
        konto1.einzahlen(1000);
        konto2.einzahlen(2000);
        konto3.einzahlen(3000);
        konto4.einzahlen(4000);
        konto5.einzahlen(5000);

        // Abhebungen
        konto1.abheben(500);
        konto2.abheben(1000);
        konto3.abheben(1500);
        konto4.abheben(2000);
        konto5.abheben(2500);

        // Überweisungen
        konto1.ueberweisen(konto2, 100);
        konto3.ueberweisen(konto4, 200);
        konto5.ueberweisen(konto1, 300);

        // Print
        konto1.gibKontoinformationen();
        konto1.printTransaktionshistorien();
        System.out.println();

        konto2.gibKontoinformationen();
        konto2.printTransaktionshistorien();
        System.out.println();

        konto3.gibKontoinformationen();
        konto3.printTransaktionshistorien();
        System.out.println();

        konto4.gibKontoinformationen();
        konto4.printTransaktionshistorien();
        System.out.println();

        konto5.gibKontoinformationen();
        konto5.printTransaktionshistorien();
    }

}
