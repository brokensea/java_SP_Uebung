package DAY14_11_7_2024.boot;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Boot {
    // länge, breite, tiefgang, freiboard
    // hasMotor: segelboot (masthöhe) vs. motorboot
    // personCount
    // isLicenceRequired
    // availability: Reservation[] from, to, person

    private String type; // Segelboot | Motorboot
    private int personCount;
    private boolean isLicenceRequired;
    private double pricePerHour;
    private ArrayList<Reservation> reservations;

    // private static int nextId = 1;
    private int id;

    public Boot(String type, int personCount, boolean isLicenceRequired, double pricePerHour) {
        this.setType(type);
        this.setPersonCount(personCount);
        this.setIsLicenceRequired(isLicenceRequired);
        this.setPricePerHour(pricePerHour);
        this.reservations = new ArrayList<Reservation>();
        this.id = generateUniqueId();
    }

    public int getId() {
        return id;
    }

    private synchronized int generateUniqueId() {
        return nextId++;
    }

    public void setType(String type) {
        if (!type.equals("Segelboot") && !type.equals("Motorboot"))
            throw new IllegalArgumentException("Bootstyp muss Segelboot oder Motorboot sein");
        this.type = type;
    }

    public void setPersonCount(int personCount) {
        if (personCount <= 0)
            throw new IllegalArgumentException("Personcount muss größer als 0 sein");
        this.personCount = personCount;
    }

    public void setIsLicenceRequired(boolean isLicenceRequired) {
        this.isLicenceRequired = isLicenceRequired;
    }

    public void setPricePerHour(double pricePerHour) {
        if (pricePerHour < 0.0)
            throw new IllegalArgumentException("Personcount muss positiv sein");
        this.pricePerHour = pricePerHour;
    }

    public String getType() {
        return type;
    }

    public int getPersonCount() {
        return personCount;
    }

    public boolean isLicenceRequired() {
        return isLicenceRequired;
    }

    public double getPicePerHour() {
        return pricePerHour;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public Reservation addReservation(LocalDateTime from, LocalDateTime to, Person p) {
        boolean licenceOK = !isLicenceRequired || (isLicenceRequired && p.hasLicence());
        if (!licenceOK) {
            throw new IllegalStateException("Licence required to book this boat");
        }

        // Check availability based on from and to values
        boolean isAvailable = checkIsAvailable(from, to);
        if (!isAvailable) {
            throw new IllegalStateException("Boat not available, please try a different time");
        }

        // Create a new Reservation with the current Boot's ID
        Reservation reservation = new Reservation(p, from, to, this.getId(), this);
        reservations.add(reservation);

        // Add reservation to person
        p.addReservation(reservation);

        return reservation;
    }

    // public Reservation addReservation(LocalDateTime from, LocalDateTime to,
    // Person p) {
    // boolean licenceOK = !isLicenceRequired || isLicenceRequired &&
    // p.hasLicence();
    // if (!licenceOK)
    // throw new IllegalStateException("Licence required to book this boat");

    // // check availability based on from and to values!!!
    // boolean isAvailable = checkIsAvailable(from, to);
    // if (!isAvailable)
    // throw new IllegalStateException("Boat not available, please try a different
    // time");

    // Reservation reservation = new Reservation(p, from, to, this.id);
    // reservations.add(reservation);

    // // add
    // p.addReservation(reservation);

    // return reservation;
    // }

    private boolean checkIsAvailable(LocalDateTime from, LocalDateTime to) {
        // if can find a reservation that overlaps --> return false
        // else return true
        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            boolean isOverlapping = to.isAfter(reservation.getFrom()) &&
                    from.isBefore(reservation.getTo());
            if (isOverlapping)
                return false;
        }
        return true;
    }

    public void printReservations() {
        System.out.println("Reservations of " + this.getType());
        for (Reservation r : reservations) {
            System.out.println("\t" + r.toString());
        }
    }
}