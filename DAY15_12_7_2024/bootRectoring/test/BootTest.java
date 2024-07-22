// package DAY15_11_2024.bootRectoring.test;

// import org.junit.Before;
// import org.junit.Test;

// import java.time.LocalDateTime;
// import java.util.ArrayList;

// import static org.junit.Assert.*;

// public class BootTest {
// private Boot segelboot;
// private Boot motorboot;
// private Person person;
// private Bootsverleih bootsverleih;

// @Before
// public void setUp() {
// bootsverleih = new Bootsverleih();
// segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
// motorboot = new Boot("Motorboot", 6, false, 30.0, 25.0, bootsverleih);
// person = new Person("John Doe", true);

// bootsverleih.addBoot(segelboot);
// bootsverleih.addBoot(motorboot);
// bootsverleih.addKunde(person);
// }

// @Test
// public void testAddReservation() {
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(3);
// Reservation reservation = segelboot.addReservation(from, to, person);
// assertNotNull(reservation);
// assertEquals(1, segelboot.getReservations().size());
// assertEquals(person, reservation.getPerson());
// assertEquals(segelboot.getId(), reservation.getBootID());
// }

// @Test(expected = IllegalStateException.class)
// public void testAddReservationWithNoLicence() {
// Person noLicencePerson = new Person("Jane Doe", false);
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(3);
// segelboot.addReservation(from, to, noLicencePerson);
// }

// @Test
// public void testCalculatePrice() {
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(3);
// Reservation reservation = new Reservation(person, from, to,
// segelboot.getId(), segelboot);
// double price = reservation.calculatePrice();
// assertEquals(50.0, price, 0.0);
// }
// }
