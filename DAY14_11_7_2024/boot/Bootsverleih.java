package DAY14_11_7_2024.boot;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bootsverleih {
    private ArrayList<Boot> boote;
    private ArrayList<Person> kunden;
    private double totalRevenue; // Gesamtumsatz

    public Bootsverleih() {
        this.boote = new ArrayList<>();
        this.kunden = new ArrayList<>();
        this.totalRevenue = 0.0; // Gesamtumsatz
    }

    // Methode, die eine Reservierung hinzufügt und den Umsatz aktualisiert
    public double addReservationAndGetRevenue(Reservation reservation) {
        double reservationHours = reservation.calculateDurationInHours();
        double pricePerHour = reservation.getBoot().getPicePerHour();
        double reservationRevenue = reservationHours * pricePerHour;

        // Gesamtumsatz aktualisieren
        totalRevenue += reservationRevenue;

        return totalRevenue;
    }

    // Method that returns the boat with the highest sales in the last N days
    //
    public Boot boatWithHighestRevenue(int lastNDays) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime cutoffDate = now.minusDays(lastNDays);

        Boot bootWithHighestRevenue = null;
        double maxRevenue = 0.0;

        // Go through all boats and calculate the turnover for the specified
        // period
        for (Boot boot : boote) {
            double bootRevenue = 0.0;
            for (Reservation reservation : boot.getReservations()) {
                LocalDateTime reservationFrom = reservation.getFrom();
                if (reservationFrom.isAfter(cutoffDate)) {
                    double reservationHours = reservation.calculateDurationInHours();
                    double pricePerHour = boot.getPicePerHour();
                    bootRevenue += reservationHours * pricePerHour;
                }
            }

            // Check if this boat has the highest sales to date
            if (bootRevenue > maxRevenue) {
                maxRevenue = bootRevenue;
                bootWithHighestRevenue = boot;
            }
        }

        return bootWithHighestRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void addBoot(Boot boot) {
        this.boote.add(boot);
    }

    public void addKunde(Person kunde) {
        this.kunden.add(kunde);
    }

    // the customer with the most reservation (count)
    public Person topCustomer() {
        if (kunden.isEmpty())
            return null;

        Person topP = kunden.get(0);
        for (Person k : kunden) {
            if (k.getTotalReservationStunden() > topP.getTotalReservationStunden())
                topP = k;
        }
        return topP;
    }

    public Boot beliebtesteBootanhandAnzahlReservierungen() {
        if (boote.isEmpty()) {
            System.out.println("Keine Boote verfügbar.");
            return null;
        }

        Boot beliebtBoot = boote.get(0);
        int maxReservations = beliebtBoot.getReservations().size();

        // Find the maximum reservations count
        for (Boot boot : boote) {
            int reservationsCount = boot.getReservations().size();
            if (reservationsCount > maxReservations) {
                maxReservations = reservationsCount;
                beliebtBoot = boot;
            }
        }
        System.out.println("beliebtestes Boot ID ist: " + beliebtBoot.getId());

        // Return the most popular boot
        return beliebtBoot;
    }

}