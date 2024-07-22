package DAY15_11_2024.bootRectoring.test2;

import DAY15_11_2024.bootRectoring.*;
import java.time.LocalDateTime;

public class PersonTest {
    private Person person;
    private Boot segelboot;
    private Boot motorboot;
    private Bootsverleih bootsverleih;

    public void setUp() {
        person = new Person("Person_A", true);
        bootsverleih = new Bootsverleih();
        segelboot = new Boot("Segelboot", 4, true, 20.0, 15.0, bootsverleih);
        motorboot = new Boot("Motorboot", 6, false, 30.0, 25.0, bootsverleih);
    }

    public void testGetFavoriteBootID() {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusHours(2);
        person.addReservation(new Reservation(person, from, to, segelboot.getId(), segelboot));
        person.addReservation(new Reservation(person, from.plusDays(1), to.plusDays(1), segelboot.getId(), segelboot));
        person.addReservation(new Reservation(person, from.plusDays(2), to.plusDays(2), motorboot.getId(), motorboot));

        int favoriteBootID = person.getFavoriteBootID();
        if (favoriteBootID == segelboot.getId()) {
            System.out.println("testGetFavoriteBootID passed.");
        } else {
            System.out.println("testGetFavoriteBootID failed.");
        }
    }

    public void testAddReservation() {
        LocalDateTime from = LocalDateTime.of(2024, 7, 12, 10, 0); // fix time
        LocalDateTime to = from.plusHours(2);
        Reservation reservation = new Reservation(person, from, to, segelboot.getId(), segelboot);
        person.addReservation(reservation);

        // test
        if (person.getReservations().size() == 1 &&
                person.getTotalReservationStunden() == 2) {
            System.out.println("testAddReservation passed.");
        } else {
            System.out.println("testAddReservation failed.");
        }
    }

    public static void main(String[] args) {
        PersonTest test = new PersonTest();
        test.setUp();
        // test.testGetFavoriteBootID();
        test.testAddReservation();
    }
}
