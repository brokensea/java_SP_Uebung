package DAY20_22_7_2024.javaOOP;

import java.util.*;
import java.util.function.Function;

public class VerbesserungManagementSystem {
    private List<Event> events;
    private List<Participant> participants;

    // verbesserung 1
    public VerbesserungManagementSystem() {
        this.events = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public void addEvent(String nameEvent, Date date, String locationEvent, int maxParticipants) {
        Event event = new Event(nameEvent, date, locationEvent, maxParticipants);
        events.add(event);
    }

    // verbesserung 2 remove duplicate; removeEvent; removeParticipant; DRY
    private <T> void remove(List<T> list, String string, Function<T, String> getString) {
        T toRemove = null;
        for (T item : list) {
            if (getString.apply(item).equals(string)) {
                toRemove = item;
                break;
            }
        }
        if (toRemove != null) {
            list.remove(toRemove);
        }

    }

    public void removeEvent(String nameEvent) {
        remove(events, nameEvent, Event::getName);
    }

    public void removeParticipant(String email) {
        remove(participants, email, Participant::getEmail);
    }

    public void addParticipant(String firstName, String lastName, String email) {
        Participant participant = new Participant(firstName, lastName, email);
        participants.add(participant);
    }

    // verbesserung 4: Die Logik zum Finden von Veranstaltungen und Teilnehmern kann
    // in Hilfsmethoden ausgelagert werden, um Wiederholungen zu vermeiden.
    // Prinzip: Single Responsibility Principle (SRP)
    private Event findEventByName(String name) {
        for (Event e : events) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    private Participant findParticipantByEmail(String email) {
        for (Participant p : participants) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        return null;
    }

    public void registerParticipantToEvent(String eventName, String participantEmail) {
        Event event = findEventByName(eventName);
        Participant participant = findParticipantByEmail(participantEmail);

        if (event != null && participant != null) {
            if (event.getParticipants().size() < event.getMaxParticipants()) {
                event.getParticipants().add(participant);
            } else {
                System.out.println("Maximale Teilnehmerzahl erreicht");
            }
        }
    }

    public void unregisterParticipantFromEvent(String eventName, String participantEmail) {
        Event event = findEventByName(eventName);

        if (event != null) {
            Participant toRemove = findParticipantByEmail(participantEmail);
            if (toRemove != null) {
                event.getParticipants().remove(toRemove);
            }
        }
    }

    // verbesserung 4
    // Die Logik zum Drucken von Informationen sollte in eigene
    // Formatierungsmethoden ausgelagert werden.
    // Prinzip: Separation of Concerns

    private void printEventDetails(Event event) {
        System.out.println("Event: " + event.getName() + ", Ort: " + event.getLocation());
        for (Participant participant : event.getParticipants()) {
            System.out.println(
                    "Teilnehmer: " + participant.getFirstName() + " " + participant.getLastName() + ", E-Mail: "
                            + participant.getEmail());
        }
    }

    private void printParticipantDetails(Participant participant) {
        System.out.println("Teilnehmer: " + participant.getFirstName() + " " + participant.getLastName() + ", E-Mail: "
                + participant.getEmail());
    }

    public void displayEvents() {
        for (Event event : events) {
            printEventDetails(event);
        }
    }

    public void displayParticipants() {
        for (Participant participant : participants) {
            printParticipantDetails(participant);
        }
    }

    public static void main(String[] args) {
        EventManagementSystem system = new EventManagementSystem();
        system.addEvent("Java-Konferenz", new Date(), "Berlin", 100);
        system.addParticipant("Max", "Mustermann", "max@example.com");
        system.registerParticipantToEvent("Java-Konferenz", "max@example.com");
        system.displayEvents();
    }
}

// verbesserung 3: Kapselung von Feldern : Prinzip: Encapsulation
// Verstecken von Implementierungsdetails: Felder sind privat und können nur
// durch Methoden (Getter) verändert werden.
// Sicherheit: Verhindert direkte Änderungen an den Feldern von außen.

class Event {
    private String name;
    private Date date;
    private String location;
    private int maxParticipants;
    private List<Participant> participants;

    public Event(String name, Date date, String location, int maxParticipants) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.participants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}

class Participant {
    private String firstName;
    private String lastName;
    private String email;

    public Participant(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}

// verbessertung 1:
// Vorteile der Verschiebung der Initialisierung in den Konstruktor
// Höhere Flexibilität:

// Verzögerte Initialisierung: Wenn die Initialisierung der Felder in den
// Konstruktor verschoben wird, ermöglicht das eine verzögerte Initialisierung.
// So kann die Initialisierung flexibler an verschiedene Parameter oder
// Bedingungen angepasst werden.
// Dynamische Konfiguration: Über den Konstruktor können unterschiedliche
// Implementierungen oder Konfigurationsoptionen für die Felder verwendet
// werden, je nach Bedarf.
// Verbesserte Testbarkeit:

// Einfachere Tests: In Unit-Tests können Objekte mit speziellen
// Initialisierungen erstellt werden, um bestimmte Konstruktorverhalten zu
// testen oder die Initialisierung zu überprüfen.
// Abhängigkeitsinjektion: Es wird möglich, Abhängigkeiten durch den Konstruktor
// zu injizieren, was für Tests von Vorteil sein kann, da verschiedene
// Konfigurationen oder Implementierungen verwendet werden können.
// Bessere Wartbarkeit:

// Klarere Initialisierungslogik: Die Initialisierungslogik ist im Konstruktor
// gebündelt, was die Wartung vereinfacht, da Änderungen zentral vorgenommen
// werden können.
// Vermeidung potenzieller Probleme: Die Verschiebung der Initialisierung in den
// Konstruktor hilft, potenzielle Probleme wie Thread-Sicherheit oder
// Initialisierungsreihenfolge zu vermeiden.
// Einhaltung von Entwurfsprinzipien:

// Prinzip der Einzelverantwortung: Der Konstruktor ist für die Erstellung und
// Initialisierung des Objekts verantwortlich, während die Felder nur die
// Datenstruktur definieren. Dies entspricht dem Prinzip der
// Einzelverantwortung, da die Aufgaben klar getrennt sind.
// Wahrung der Kapselung: Durch die Initialisierung im Konstruktor kann die
// Initialisierung des Feldes kontrolliert und gekapselt werden, anstatt
// komplexe Initialisierungen direkt bei der Deklaration der Felder vorzunehmen.