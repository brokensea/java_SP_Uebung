package DAY14_11_7_2024.boot;

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

    // public void addReservation(Reservation reservation) {
    // reservations.add(reservation);
    // this.updateTotalReservationStunden();
    // }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        int bootID = reservation.getBootID();
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

    // Totale
    public int getTotalReservationStunden() {
        return totalReservationStunden;
    }

    // jeder Reservation
    public double calculateTotalReservationDuration() {
        long totalHours = 0;
        for (Reservation reservation : reservations) {
            LocalDateTime from = reservation.getFrom();
            LocalDateTime to = reservation.getTo();
            Duration duration = Duration.between(from, to);
            totalHours += duration.toHours();
        }

        return totalHours;
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

        System.out.println(this.name + "liebsten Boot ist " + favoriteBootID);
        return favoriteBootID;
    }

}