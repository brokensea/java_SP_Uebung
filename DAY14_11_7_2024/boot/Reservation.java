package DAY14_11_7_2024.boot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Reservation {
    private Person person;
    private LocalDateTime from;
    private LocalDateTime to;
    private Boot boot;
    private int bootID;

    public Reservation(Person person, LocalDateTime from, LocalDateTime to, int bootID, Boot boot) {
        this.person = person;
        this.from = from;
        this.to = to;
        this.bootID = bootID;
        this.boot = boot;
    }

    public Boot getBoot() {
        return boot;
    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    public int getBootID() {
        return bootID;
    }

    public void setBootID(int bootID) {
        this.bootID = bootID;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public long calculateDurationInHours() {
        Duration duration = Duration.between(from, to);
        return duration.toHours();
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE dd.MMM HH:mm");
        return "From " + this.getFrom().format(format) +
                " | To " + this.getTo().format(format) +
                " | By " + this.getPerson().getName() + " (Licence: " + this.getPerson().hasLicence() + "bootID ist: "
                + bootID + ")";
    }
}
