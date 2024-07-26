package DAY22_24_7_2024.packageAufgabe.com.example.main;

import DAY22_24_7_2024.packageAufgabe.com.example.library.*;

public class MainTest {
    public static void main(String[] args) {
        // libraryTest();
        testUebung2();
    }

    public static void testUebung2() {

        // 1. Teste EBook.read() Methode
        EBook ebook = new EBook("Digital Fortress", "Dan Brown", "123-456-789", 1998, 5);
        ebook.read();

        // 2. Teste PrintedBook.read() Methode
        PrintedBook printedBook = new PrintedBook("The Catcher in the Rye", "J.D. Salinger", "987-654-321", 1951, 300);
        printedBook.read();

        // 3. Teste Leihsystem.ausleihen() Methode
        Benutzerverwaltung.Benutzer benutzer1 = new Benutzerverwaltung().new Benutzer();
        benutzer1.setNameBenutzer(benutzer1);
        benutzer1.setBenutzerType(BenutzerType.NormaleBenutzer);
        benutzer1.setDarfAusleihen(true);
        benutzer1.setLoan(new Loan());

        Leihsystem.ausleihen(benutzer1, ebook);
        Leihsystem.ausleihen(benutzer1, printedBook);

        // 4. Teste Leihsystem.zurueckgeben() Methode
        Leihsystem.zurueckgeben(benutzer1, ebook);
        Leihsystem.zurueckgeben(benutzer1, printedBook);

        // 5. Teste Library.findBooksByAuthor() Methode
        Library library = new Library();
        library.addBook(ebook);
        library.addBook(printedBook);

        System.out.println("Bücher von Dan Brown:");
        for (Book book : library.findBooksByAuthor("Dan Brown")) {
            System.out.println(book);
        }
    }
}

// public static void libraryTest() {
// // Erstellen Sie eine Bibliothek
// Library library = new Library();

// // Erstellen Sie einige Bücher
// Book book1 = new Book("1984", "George Orwell", "123-456-789", 1949);
// Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "987-654-321",
// 1960);
// Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald",
// "456-789-123", 1925);

// // Fügen Sie die Bücher zur Bibliothek hinzu
// library.addBook(book1);
// library.addBook(book2);
// library.addBook(book3);

// // Liste alle Bücher in der Bibliothek auf
// library.aufListBook();

// // Drucke Details eines bestimmten Buches
// library.printBookDetails(book2);
// }
// }
