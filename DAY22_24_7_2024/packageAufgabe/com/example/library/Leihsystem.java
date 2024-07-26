package DAY22_24_7_2024.packageAufgabe.com.example.library;

import DAY22_24_7_2024.packageAufgabe.com.example.library.Benutzerverwaltung.Benutzer;

public class Leihsystem {
    // need test
    public static void ausleihen(Benutzer benutzer, Book book) {
        if (benutzer.getBenutzerType() == BenutzerType.Administratoren || benutzer.isDarfAusleihen() == true) {
            benutzer.getLoan().addLoanBookList(book);
        } else {
            System.out.println(benutzer.getNameBenutzer() + " darf nicht ausleihen");
        }
    }

    // need Test
    public static void zurueckgeben(Benutzer benutzer, Book book) {
        if (benutzer.getLoan().getLoanBookList().contains(book)) {
            benutzer.getLoan().getLoanBookList().remove(book);
            System.out.println(book.getTitle() + " ist zurückgegeben");
        } else {
            System.out.println(benutzer.getNameBenutzer() + " hat das Buch nicht ");
        }
    }
}
