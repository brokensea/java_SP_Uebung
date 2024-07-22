// package DAY15_11_2024.bootRectoring.test;

// import org.junit.Before;
// import org.junit.Test;

// import java.time.LocalDateTime;

// import static org.junit.Assert.*;

// public class BootsverleihTest {
// private Bootsverleih bootsverleih;
// private Boot segelboot;
// private Boot motorboot;
// private Person person1;
// private Person person2;

// @Before
// public void setUp() {
// bootsverleih = new Bootsverleih();
// segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
// motorboot = new Boot("Motorboot", 6, false, 30.0, 25.0, bootsverleih);
// person1 = new Person("John Doe", true);
// person2 = new Person("Jane Doe", true);

// bootsverleih.addBoot(segelboot);
// bootsverleih.addBoot(motorboot);
// bootsverleih.addKunde(person1);
// bootsverleih.addKunde(person2);
// }

// @Test
// public void testAddReservationAndGetRevenue() {
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(3);
// Reservation reservation = segelboot.addReservation(from, to, person1);
// double revenue = bootsverleih.addReservationAndGetRevenue(reservation);
// assertEquals(50.0, revenue, 0.0);
// }

// @Test
// public void testBoatWithHighestRevenue() {
// LocalDateTime now = LocalDateTime.now();
// Reservation reservation1 = segelboot.addReservation(now.minusDays(1),
// now.minusDays(1).plusHours(4), person1);
// bootsverleih.addReservationAndGetRevenue(reservation1);
// Reservation reservation2 = motorboot.addReservation(now.minusDays(2),
// now.minusDays(2).plusHours(3), person2);
// bootsverleih.addReservationAndGetRevenue(reservation2);

// Boot highestRevenueBoat = bootsverleih.boatWithHighestRevenue(3);
// assertEquals(segelboot.getId(), highestRevenueBoat.getId());
// }

// @Test
// public void testTopCustomer() {
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(2);
// person1.addReservation(new Reservation(person1, from, to, segelboot.getId(),
// segelboot));
// person1.addReservation(
// new Reservation(person1, from.plusDays(1), to.plusDays(1), segelboot.getId(),
// segelboot));
// person2.addReservation(new Reservation(person2, from, to, motorboot.getId(),
// motorboot));

// Person topCustomer = bootsverleih.topCustomer();
// assertEquals(person1.getName(), topCustomer.getName());
// }

// @Test
// public void testBeliebtesteBootanhandAnzahlReservierungen() {
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(2);
// segelboot.addReservation(from, to, person1);
// segelboot.addReservation(from.plusDays(1), to.plusDays(1), person2);
// motorboot.addReservation(from.plusDays(2), to.plusDays(2), person1);

// Boot mostPopularBoat =
// bootsverleih.beliebtesteBootanhandAnzahlReservierungen();
// assertEquals(segelboot.getId(), mostPopularBoat.getId());
// }

// @Test
// public void testGeringstenBootanhandAnzahlReservierungen() {
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(2);
// segelboot.addReservation(from, to, person1);
// segelboot.addReservation(from.plusDays(1), to.plusDays(1), person2);

// Boot leastPopularBoat =
// bootsverleih.geringstenBootanhandAnzahlReservierungen();
// assertEquals(motorboot.getId(), leastPopularBoat.getId());
// }
// }
