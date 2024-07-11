package DAY14_11_7_2024.boot;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        // test(); // Test der Basisfunktionen
        // testTopCustomer();

        // testBliebtesteBootanhandAnzahlReservierungen();
        // testGetFavoriteBootID();
        testAddReservationAndGetRevenue_boatWithHighestRevenue();

    }

    public static void test() {
        Boot boot1 = new Boot("Segelboot", 4, false, 20);
        Boot boot2 = new Boot("Motorboot", 4, false, 36);
        Boot boot3 = new Boot("Motorboot", 2, true, 28);
        Boot boot4 = new Boot("Segelboot", 16, true, 92);
        Boot boot5 = new Boot("Segelboot", 2, false, 16);

        Person andreas = new Person("Kund_A", true);
        Person anton = new Person("Kund_B", true);
        Person peter = new Person("Kund_C", false);

        LocalDateTime sonnabend12 = LocalDateTime.of(2024, Month.JULY, 13, 12, 0);
        LocalDateTime sonntag11 = LocalDateTime.of(2024, Month.JULY, 14, 11, 0);
        LocalDateTime sonntagNach11 = LocalDateTime.of(2024, Month.JULY, 14, 11, 1);
        LocalDateTime montag12 = LocalDateTime.of(2024, Month.JULY, 15, 12, 0);

        // boot3.addReservation(sonnabend12, sonntag11, peter); // Licence required!

        boot3.addReservation(sonnabend12, sonntag11, andreas);

        boot3.addReservation(sonntagNach11, montag12, anton);

        boot3.printReservations();
    }

    public static void testTopCustomer() {
        // Erstelle den Bootsverleih
        Bootsverleih verleih = new Bootsverleih();

        // Erstelle einige Boote
        Boot segelboot = new Boot("Segelboot", 4, false, 20.0);
        Boot motorboot = new Boot("Motorboot", 6, true, 35.0);
        verleih.addBoot(segelboot);
        verleih.addBoot(motorboot);

        // Erstelle einige Kunden
        Person kunde1 = new Person("Alice", true);
        Person kunde2 = new Person("Bob", false);
        verleih.addKunde(kunde1);
        verleih.addKunde(kunde2);

        // Erstelle einige Reservierungen
        LocalDateTime start1 = LocalDateTime.of(2024, 7, 10, 10, 0);
        LocalDateTime end1 = LocalDateTime.of(2024, 7, 10, 12, 0);
        segelboot.addReservation(start1, end1, kunde1);

        LocalDateTime start2 = LocalDateTime.of(2024, 7, 11, 14, 0);
        LocalDateTime end2 = LocalDateTime.of(2024, 7, 11, 18, 0);
        motorboot.addReservation(start2, end2, kunde1);

        LocalDateTime start3 = LocalDateTime.of(2024, 7, 12, 9, 0);
        LocalDateTime end3 = LocalDateTime.of(2024, 7, 12, 11, 0);
        segelboot.addReservation(start3, end3, kunde2);

        LocalDateTime start4 = LocalDateTime.of(2024, 7, 13, 15, 0);
        LocalDateTime end4 = LocalDateTime.of(2024, 7, 13, 17, 0);
        segelboot.addReservation(start4, end4, kunde2);

        // Finde den Kunden mit den meisten Reservierungsstunden
        Person topKunde = verleih.topCustomer();
        System.out.println(
                "Top-Kunde: " + topKunde.getName() + " mit " + topKunde.getTotalReservationStunden() + " Stunden.");

    }

    public static void testBliebtesteBootanhandAnzahlReservierungen() {

        // Person
        Person person1 = new Person("Alice", true);
        Person person2 = new Person("Bob", true);

        // Boot
        Boot boot1 = new Boot("Segelboot", 4, true, 50.0);
        Boot boot2 = new Boot("Motorboot", 6, false, 70.0);

        // create Bootsverleih
        Bootsverleih bootsverleih = new Bootsverleih();

        // add Boot to Bootsverleih
        bootsverleih.addBoot(boot1);
        bootsverleih.addBoot(boot2);

        // person1 book boot1
        LocalDateTime from1 = LocalDateTime.of(2024, 7, 12, 10, 0);
        LocalDateTime to1 = LocalDateTime.of(2024, 7, 12, 12, 0);
        boot1.addReservation(from1, to1, person1);

        // person2 book boot1
        LocalDateTime from2 = LocalDateTime.of(2024, 7, 12, 14, 0);
        LocalDateTime to2 = LocalDateTime.of(2024, 7, 12, 16, 0);
        boot1.addReservation(from2, to2, person2);

        // person1 book boot2
        LocalDateTime from3 = LocalDateTime.of(2024, 7, 12, 11, 0);
        LocalDateTime to3 = LocalDateTime.of(2024, 7, 12, 13, 0);
        boot2.addReservation(from3, to3, person1);

        // test beliebtesteBootanhandAnzahlReservierungen
        Boot beliebtestesBoot = bootsverleih.beliebtesteBootanhandAnzahlReservierungen();

        if (beliebtestesBoot != null) {
            System.out.println("Das beliebteste Boot ist: " + beliebtestesBoot.getId());
        } else {
            System.out.println("Es gibt keine Boote oder alle Boote haben keine Reservierungen.");
        }
    }

    public static void testGetFavoriteBootID() {

        Person person1 = new Person("Alice", true);
        Person person2 = new Person("Bob", true);

        Boot boot1 = new Boot("Segelboot", 4, true, 50.0);
        Boot boot2 = new Boot("Motorboot", 6, false, 80.0);

        Bootsverleih bootsverleih = new Bootsverleih();
        bootsverleih.addBoot(boot1);
        bootsverleih.addBoot(boot2);

        bootsverleih.addKunde(person1);
        bootsverleih.addKunde(person2);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusHours(2);

        boot1.addReservation(now, later, person1);
        boot1.addReservation(now.plusDays(1), later, person2);

        boot2.addReservation(now, later, person2);

        int favoriteBootIDAlice = person1.getFavoriteBootID(); // boot1 ID
        int favoriteBootIDBob = person2.getFavoriteBootID(); // boot2 ID

        // print
        System.out.println("Alice's favorite boot ID: " + favoriteBootIDAlice);
        System.out.println("Bob's favorite boot ID: " + favoriteBootIDBob);
    }

    public static void testAddReservationAndGetRevenue_boatWithHighestRevenue() {
        Boot boot1 = new Boot("Segelboot", 4, true, 25.0); // Example boot 1
        Boot boot2 = new Boot("Motorboot", 6, false, 35.0); // Example boot 2

        // Add boots to the boots list in the Bootsverleih instance
        Bootsverleih bootsverleih = new Bootsverleih();
        bootsverleih.addBoot(boot1);
        bootsverleih.addBoot(boot2);

        Person person1 = new Person("Max Mustermann", true); // Example person 1
        Person person2 = new Person("Erika Musterfrau", false); // Example person 2

        // Add persons to the customers list in the Bootsverleih instance
        bootsverleih.addKunde(person1);
        bootsverleih.addKunde(person2);

        // Example reservation for person 1 with boot 1
        LocalDateTime from1 = LocalDateTime.of(2024, 7, 10, 10, 0);
        LocalDateTime to1 = LocalDateTime.of(2024, 7, 10, 12, 0);
        Reservation reservation1 = new Reservation(person1, from1, to1, boot1.getId(), boot1);

        // Example reservation for person 2 with boot 2
        LocalDateTime from2 = LocalDateTime.of(2024, 7, 9, 15, 0);
        LocalDateTime to2 = LocalDateTime.of(2024, 7, 9, 18, 0);
        Reservation reservation2 = new Reservation(person2, from2, to2, boot2.getId(), boot2);

        // Add reservations to the respective boots
        boot1.addReservation(from1, to1, person1);
        boot2.addReservation(from2, to2, person2);

        // Call addReservationAndGetRevenue for both reservations
        double revenue1 = bootsverleih.addReservationAndGetRevenue(reservation1);
        double revenue2 = bootsverleih.addReservationAndGetRevenue(reservation2);

        System.out.println("Total Revenue after first reservation: " + revenue1);
        System.out.println("Total Revenue after second reservation: " + revenue2);

        // Call boatWithHighestRevenue to find the boot with highest revenue in the last
        // 7 days
        Boot highestRevenueBoot = bootsverleih.boatWithHighestRevenue(7);

        if (highestRevenueBoot != null) {
            System.out.println("Boot with highest revenue: " + highestRevenueBoot.getId());
        } else {
            System.out.println("No boot found with revenue in the last 7 days.");
        }

    }

}
