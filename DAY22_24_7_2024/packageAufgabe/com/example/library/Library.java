package DAY22_24_7_2024.packageAufgabe.com.example.library;

import java.util.ArrayList;
import java.util.List;;

public class Library {
    private List<Book> bookList;

    public Library() {
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    // Hinzufügen und Auflisten von Büchern
    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void aufListBook() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library contains ").append(bookList.size()).append(" books:\n");
        for (Book book : bookList) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    public void printBookDetails(Book book) {
        System.out.println(book.toString());
    }

    // need test
    public List<Book> findBooksByAuthor(String author) {
        ArrayList<Book> authorBookList = new ArrayList<>();
        for (Book book : this.bookList) {
            book.getAuthor().equals(author);
            authorBookList.add(book);
        }
        return authorBookList;
    }

}
