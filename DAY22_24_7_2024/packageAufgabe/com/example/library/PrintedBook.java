package DAY22_24_7_2024.packageAufgabe.com.example.library;

public class PrintedBook extends Book {
    private int weightGramm;

    public PrintedBook(String title, String author, String isbn, int year, int weightGramm) {
        super(title, author, isbn, year);
        this.setWeightGramm(weightGramm);
    }

    public int getWeightGramm() {
        return weightGramm;
    }

    public void setWeightGramm(int weightGramm) {
        this.weightGramm = weightGramm;
    }

    // ship
    public void ship() {

    }

    // need test
    @Override
    public void read() {
        // könnte die erste Seite ausgeben
        System.out.println("PrintedBook: " + this.getTitle() + "  könnte die erste Seite ausgeben");
    }

}
