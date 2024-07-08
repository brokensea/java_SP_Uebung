package DAY11_8_7_2024.javaOOP.buch;

// ###Klasse Buch erstellen:

// -Erstelle eine Klasse`Buch`,die die Attribute`titel`,`autor`,`isbn`und`seitenzahl`hat-Implementiere einen Konstruktor,der diese Attribute initialisiert-Füge Getter-und Setter-Methoden für jedes Attribut hinzu-Implementiere eine Methode`druckeDetails`,die die Details des Buches auf der Konsole ausgibt

// ###Klasse Buch verwenden:

// -erstelle eine weitere Klasse,die eine main Methode enthält-in der`main`Methode sollen mindestens fünf`Buch`Objekte erstellt und in einem Array abgelegt werden-rufe für jedes Buch die Methode`druckeDetails`auf,um die Buchdetails auf der Konsole auszugeben

// ###✨ Bonus✨ →Suchfunktion

// -Implementiere eine Methode`sucheNachISBN`in der Klasse`Buch`,die ein Array von Büchern übergeben bekommt und ein Buch anhand seiner ISBN sucht und zurückgibt.

public class Buch {

    private String titel;
    private String autor;
    private int isbn;
    private int seitenzahl;

    // Konstruktor
    public Buch(String titel, String autor, int isbn, int seitenzahl) {
        this.titel = titel;
        this.autor = autor;
        this.isbn = isbn;
        this.seitenzahl = seitenzahl;
    }

    // Getter-Methoden
    public String getTitel() {
        return titel;
    }

    public String getAutor() {
        return autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getSeitenzahl() {
        return seitenzahl;
    }

    // Setter-Methoden
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setSeitenzahl(int seitenzahl) {
        this.seitenzahl = seitenzahl;
    }

    @Override
    public String toString() {
        return "Buch{" +
                "titel='" + titel + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn=" + isbn +
                ", seitenzahl=" + seitenzahl +
                '}';
    }

    public void druckeDetails() {
        System.out.println(this.toString());
    }

    // sucheNachISBN
    public static Buch sucheNachISBN(Buch[] buecher, int isbn) {
        for (Buch b : buecher) {
            if (b.getIsbn() == isbn)
                return b;
        }
        System.out.println("Nicht gefunden");
        return null;
    }

}
