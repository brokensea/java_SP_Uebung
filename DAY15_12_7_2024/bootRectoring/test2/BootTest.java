package DAY15_11_2024.bootRectoring.test2;

import DAY15_11_2024.bootRectoring.*;
import java.time.LocalDateTime;

public class BootTest {
    private Boot segelboot;
    private Boot motorboot;
    private Person person;
    private Bootsverleih bootsverleih;

    public void setUp() {
        bootsverleih = new Bootsverleih();
        segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
        motorboot = new Boot("Motorboot", 6, false, 30.0, 25.0, bootsverleih);
        person = new Person("John Doe", true);

        bootsverleih.addBoot(segelboot);
        bootsverleih.addBoot(motorboot);
        bootsverleih.addKunde(person);
    }

    public void testAddReservation() {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(3);
        Reservation reservation = segelboot.addReservation(from, to, person);
        if (reservation != null && segelboot.getReservations().size() == 1 &&
                reservation.getPerson().equals(person) && reservation.getBootID() == segelboot.getId()) {
            System.out.println("testAddReservation passed.");
        } else {
            System.out.println("testAddReservation failed.");
        }
    }

    public void testAddReservationWithNoLicence() {
        Person noLicencePerson = new Person("Jane Doe", false);
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(3);
        try {
            segelboot.addReservation(from, to, noLicencePerson);
            System.out.println("testAddReservationWithNoLicence failed.");
        } catch (IllegalStateException e) {
            System.out.println("testAddReservationWithNoLicence passed.");
        }
    }

    // public void testCalculatePrice() {
    // LocalDateTime from = LocalDateTime.now();
    // LocalDateTime to = from.plusHours(3);
    // Reservation reservation = new Reservation(person, from, to,
    // segelboot.getId(), segelboot);
    // double price = reservation.calculatePrice();
    // if (price == 50.0) {
    // System.out.println("testCalculatePrice passed.");
    // } else {
    // System.out.println("testCalculatePrice failed.");
    // }
    // }

    public static void testCalculatePriceWithinTwoHours() {
        // Set up
        Bootsverleih bootsverleih = new Bootsverleih();
        Boot segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
        Person person = new Person("John Doe", true);
        bootsverleih.addBoot(segelboot);
        bootsverleih.addKunde(person);

        LocalDateTime from = LocalDateTime.of(2024, 7, 12, 10, 0);
        LocalDateTime to = from.plusHours(1); // Within 2 hours

        Reservation reservation = segelboot.addReservation(from, to, person);

        // Test
        double expectedPrice = 1 * segelboot.getPicePerHour(); // 1 hour at regular price
        double actualPrice = reservation.calculatePrice();

        if (actualPrice == expectedPrice) {
            System.out.println("testCalculatePriceWithinTwoHours passed.");
        } else {
            System.out.println(
                    "testCalculatePriceWithinTwoHours failed. Expected: " + expectedPrice + ", Actual: " + actualPrice);
        }
    }

    public static void testCalculatePriceOverTwoHours() {
        // Set up
        Bootsverleih bootsverleih = new Bootsverleih();
        Boot segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
        Person person = new Person("John Doe", true);
        bootsverleih.addBoot(segelboot);
        bootsverleih.addKunde(person);

        LocalDateTime from = LocalDateTime.of(2024, 7, 12, 10, 0);
        LocalDateTime to = from.plusHours(3); // Over 2 hours

        Reservation reservation = segelboot.addReservation(from, to, person);

        // Test
        double expectedPrice = 2 * segelboot.getPicePerHour() + (3 - 2) * segelboot.getDiscountedPricePerHour(); // 2
                                                                                                                 // hours
                                                                                                                 // regular
                                                                                                                 // + 1
                                                                                                                 // hour
                                                                                                                 // discounted
        double actualPrice = reservation.calculatePrice();

        if (actualPrice == expectedPrice) {
            System.out.println("testCalculatePriceOverTwoHours passed.");
        } else {
            System.out.println(
                    "testCalculatePriceOverTwoHours failed. Expected: " + expectedPrice + ", Actual: " + actualPrice);
        }
    }

    public static void main(String[] args) {
        BootTest test = new BootTest();
        test.setUp();
        test.testAddReservation();
        test.testAddReservationWithNoLicence();
        test.testCalculatePriceWithinTwoHours();
        test.testCalculatePriceOverTwoHours();
    }
}
