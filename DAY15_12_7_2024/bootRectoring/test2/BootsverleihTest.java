package DAY15_11_2024.bootRectoring.test2;

import DAY15_11_2024.bootRectoring.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BootsverleihTest {
    private Bootsverleih bootsverleih;
    private Boot segelboot;
    private Boot motorboot;
    private Person person1;
    private Person person2;

    public static void main(String[] args) {
        BootsverleihTest test = new BootsverleihTest();
        test.setUp();
        test.testBoatWithHighestRevenue();

        // test.testAddReservationAndGetRevenue();
        // test.testTopCustomer();
        // test.testBeliebtesteBootanhandAnzahlReservierungen();
        // test.testGeringstenBootanhandAnzahlReservierungen();

    }

    public void setUp() {
        bootsverleih = new Bootsverleih();
        segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
        motorboot = new Boot("Motorboot", 6, false, 30.0, 25.0, bootsverleih);
        person1 = new Person("John Doe", true);
        person2 = new Person("Jane Doe", true);

        bootsverleih.addBoot(segelboot);
        bootsverleih.addBoot(motorboot);
        bootsverleih.addKunde(person1);
        bootsverleih.addKunde(person2);
    }

    public static void testAddReservationAndGetRevenue() {
        // Set up
        Bootsverleih bootsverleih = new Bootsverleih();
        Boot segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
        Person person1 = new Person("John Doe", true);
        bootsverleih.addBoot(segelboot);
        bootsverleih.addKunde(person1);

        LocalDateTime from = LocalDateTime.of(2024, 7, 12, 10, 0);
        LocalDateTime to = from.plusHours(3);

        // Perform reservation
        Reservation reservation = segelboot.addReservation(from, to, person1);

        // Calculate expected revenue
        double reservationHours = reservation.calculateDurationInHours();
        double pricePerHour = segelboot.getPicePerHour();
        double expectedRevenue = reservationHours * pricePerHour;

        // Perform addReservationAndGetRevenue
        double actualRevenue = bootsverleih.addReservationAndGetRevenue(reservation);

        // Test
        if (actualRevenue == expectedRevenue) {
            System.out.println("testAddReservationAndGetRevenue passed.");
        } else {
            System.out.println("testAddReservationAndGetRevenue failed. Expected: " + expectedRevenue + ", Actual: "
                    + actualRevenue);
        }
    }

    public static void testBoatWithHighestRevenue() {
        // Set up
        Bootsverleih bootsverleih = new Bootsverleih();
        Boot segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
        Boot motorboot = new Boot("Motorboot", 6, false, 30.0, 25.0, bootsverleih);
        Person person1 = new Person("John Doe", true);
        Person person2 = new Person("Jane Doe", true);
        bootsverleih.addBoot(segelboot);
        bootsverleih.addBoot(motorboot);
        bootsverleih.addKunde(person1);
        bootsverleih.addKunde(person2);

        LocalDateTime now = LocalDateTime.now();

        // Make reservations
        Reservation reservation1 = segelboot.addReservation(now.minusDays(1), now.minusDays(1).plusHours(4), person1);
        bootsverleih.addReservationAndGetRevenue(reservation1);

        Reservation reservation2 = motorboot.addReservation(now.minusDays(2), now.minusDays(2).plusHours(3), person2);
        bootsverleih.addReservationAndGetRevenue(reservation2);

        // Test
        Boot highestRevenueBoat = bootsverleih.boatWithHighestRevenue(3);
        if (highestRevenueBoat.getId() == segelboot.getId()) {
            System.out.println("testBoatWithHighestRevenue passed.");
        } else {
            System.out.println("testBoatWithHighestRevenue failed.");
        }
    }

    public void testTopCustomer() {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        person1.addReservation(new Reservation(person1, from, to, segelboot.getId(), segelboot));
        person1.addReservation(
                new Reservation(person1, from.plusDays(1), to.plusDays(1), segelboot.getId(), segelboot));
        person2.addReservation(new Reservation(person2, from, to, motorboot.getId(), motorboot));

        Person topCustomer = bootsverleih.topCustomer();
        if (topCustomer.getName().equals(person1.getName())) {
            System.out.println("testTopCustomer passed.");
        } else {
            System.out.println("testTopCustomer failed.");
        }
    }

    public void testBeliebtesteBootanhandAnzahlReservierungen() {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        segelboot.addReservation(from, to, person1);
        segelboot.addReservation(from.plusDays(1), to.plusDays(1), person2);
        motorboot.addReservation(from.plusDays(2), to.plusDays(2), person1);

        Boot mostPopularBoat = bootsverleih.beliebtesteBootanhandAnzahlReservierungen();
        if (mostPopularBoat.getId() == segelboot.getId()) {
            System.out.println("testBeliebtesteBootanhandAnzahlReservierungen passed.");
        } else {
            System.out.println("testBeliebtesteBootanhandAnzahlReservierungen failed.");
        }
    }

    public void testGeringstenBootanhandAnzahlReservierungen() {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        segelboot.addReservation(from, to, person1);
        segelboot.addReservation(from.plusDays(1), to.plusDays(1), person2);

        Boot leastPopularBoat = bootsverleih.geringstenBootanhandAnzahlReservierungen();
        if (leastPopularBoat.getId() == motorboot.getId()) {
            System.out.println("testGeringstenBootanhandAnzahlReservierungen passed.");
        } else {
            System.out.println("testGeringstenBootanhandAnzahlReservierungen failed.");
        }
    }

}
