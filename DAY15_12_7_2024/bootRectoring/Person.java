package DAY15_11_2024.bootRectoring;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private boolean hasLicence;
    private ArrayList<Reservation> reservations;
    private int totalReservationStunden;
    private HashMap<Integer, Integer> reservationsPerBoot;

    // reservationsPerBoot is
    // a HashMap<Integer,Integer>,
    // whose key is the ID of
    // the boat (Integer) and whose value is the number of reservations for the
    // corresponding boat (Integer).
    // Using HashMap, you can quickly find and update the number of reservations
    // based on the boat ID. The time complexity of the operation
    // is O(1), which can efficiently handle a large amount of reservation
    // information.

    public Person(String name, boolean hasLicence) {
        this.name = name;
        this.hasLicence = hasLicence;
        this.reservations = new ArrayList<>();
        this.reservationsPerBoot = new HashMap<>(); // Initialize the HashMap
    }

    public String getName() {
        return this.name;
    }

    public boolean hasLicence() {
        return this.hasLicence;
    }

    /**
     * @param reservation
     * 
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        int bootID = reservation.getBootID();
        // Get the number of reservations corresponding to the specified bootID from the
        // reservationsPerBoot Map. If bootID does not exist in reservationsPerBoot,
        // return the default value 0.
        int count = reservationsPerBoot.getOrDefault(bootID, 0);
        reservationsPerBoot.put(bootID, count + 1);
        this.updateTotalReservationStunden();
        // update total reservation Stunden
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    // update TotalReservation
    private void updateTotalReservationStunden() {
        long totalHours = 0;
        for (Reservation reservation : reservations) {
            LocalDateTime from = reservation.getFrom();
            LocalDateTime to = reservation.getTo();
            Duration duration = Duration.between(from, to);
            totalHours += duration.toHours();
        }
        this.totalReservationStunden = (int) totalHours; // Studen
    }

    // Totale Reservation Stunden
    public int getTotalReservationStunden() {
        return totalReservationStunden;
    }

    // implementiere eine Methode, die das Lieblingsboot einer Person ermittelt.
    // Dabei ist das Lieblingsboot das, welches er am häufigsten reserviert hat
    public int getFavoriteBootID() {
        int favoriteBootID = -1;
        int maxReservations = 0;
        for (Map.Entry<Integer, Integer> entry : reservationsPerBoot.entrySet()) {
            int bootID = entry.getKey();
            int count = entry.getValue();

            if (count > maxReservations) {
                maxReservations = count;
                favoriteBootID = bootID;
            }
        }

        System.out.println(
                this.name + "liebsten Boot ist " + favoriteBootID + " mit " + maxReservations + " Mal reserviert ");
        return favoriteBootID;
    }

}