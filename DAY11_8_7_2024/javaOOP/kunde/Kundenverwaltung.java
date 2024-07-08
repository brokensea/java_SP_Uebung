package DAY11_8_7_2024.javaOOP.kunde;

public class Kundenverwaltung {
    public static void main(String[] args) {
        Kunde max = new Kunde(1, "Max Mustermann", "max@g.com", 123456789);
        Kunde erika = new Kunde(2, "Erika Musterfrau");
        Kunde hans = new Kunde(3, "Hans Müller", "hans@g.com");

        max.printDetails();
        erika.printDetails();
        hans.printDetails();

    }
}
