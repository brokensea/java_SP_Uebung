package DAY11_8_7_2024.javaOOP.buch;

public class MainBuch {
    private Buch[] buecher;

    public static void main(String[] args) {
        MainBuch main = new MainBuch();
        main.init();

    }

    private void init() {
        Buch buch1 = new Buch("Der Herr der Ringe", "J.R.R. Tolkien", 123456, 1200);
        Buch buch2 = new Buch("Harry Potter", "J.K. Rowling", 654321, 500);
        Buch buch3 = new Buch("Der Hobbit", "J.R.R. Tolkien", 789012, 300);
        Buch buch4 = new Buch("Die Tribute von Panem", "Suzanne Collins", 345678, 400);
        Buch buch5 = new Buch("Der kleine Prinz", "Antoine de Saint-Exupéry", 987654, 150);

        Buch[] buecher = { buch1, buch2, buch3, buch4, buch5 };

        for (Buch b : buecher) {
            b.druckeDetails();
            System.out.println();
        }
        // Suche nach einem Buch anhand der ISBN
        int gesuchteIsbn = 789012;
        Buch gefundenesBuch = Buch.sucheNachISBN(buecher, gesuchteIsbn);

        if (gefundenesBuch != null) {
            System.out.println("Buch mit ISBN " + gesuchteIsbn + " gefunden:");
            gefundenesBuch.druckeDetails();
        } else {
            System.out.println("Buch mit ISBN " + gesuchteIsbn + " nicht gefunden.");
        }

    }

}
