package DAY22_24_7_2024.packageAufgabe.com.example.library;

public class EBook extends Book {
    private int fileSizeMB;

    public EBook(String title, String author, String isbn, int year, int fileSizeMB) {
        super(title, author, isbn, year);
        this.setFileSizeMB(fileSizeMB);
    }

    public int getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(int fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    // download
    public void download() {

    }

    // need test
    @Override
    public void read() {
        // EBook könnte z.B. eine Lesesoftware öffnen,

        System.out.println("Ebook: " + this.getTitle() + " eine Lesesoftware öffnen");
    }

}
