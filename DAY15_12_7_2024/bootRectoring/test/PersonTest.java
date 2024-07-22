// package DAY15_11_2024.bootRectoring.test;

// import org.junit.Before;
// import org.junit.Test;

// import java.time.LocalDateTime;

// import static org.junit.Assert.*;

// public class PersonTest {
// private Person person;
// private Boot segelboot;
// private Boot motorboot;
// private Bootsverleih bootsverleih;

// @Before
// public void setUp() {
// person = new Person("John Doe", true);
// bootsverleih = new Bootsverleih();
// segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
// motorboot = new Boot("Motorboot", 6, false, 30.0, 25.0, bootsverleih);
// }

// @Test
// public void testGetFavoriteBootID() {
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(2);
// person.addReservation(new Reservation(person, from, to, segelboot.getId(),
// segelboot));
// person.addReservation(new Reservation(person, from.plusDays(1),
// to.plusDays(1), segelboot.getId(), segelboot));
// person.addReservation(new Reservation(person, from.plusDays(2),
// to.plusDays(2), motorboot.getId(), motorboot));

// int favoriteBootID = person.getFavoriteBootID();
// assertEquals(segelboot.getId(), favoriteBootID);
// }

// @Test
// public void testAddReservation() {
// LocalDateTime from = LocalDateTime.now();
// LocalDateTime to = from.plusHours(2);
// Reservation reservation = new Reservation(person, from, to,
// segelboot.getId(), segelboot);
// person.addReservation(reservation);

// assertEquals(1, person.getReservations().size());
// assertEquals(2, person.getTotalReservationStunden());
// }
// }
