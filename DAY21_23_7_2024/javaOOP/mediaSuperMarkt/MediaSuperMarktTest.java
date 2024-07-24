package DAY21_23_7_2024.javaOOP.mediaSuperMarkt;

public class MediaSuperMarktTest {
    public static void main(String[] args) {
        MediaSuperMarkt mediaSuperMarkt = new MediaSuperMarkt();

        // Erstellen von verschiedenen Geraet-Objekten
        Geraet fernseher = new Fernseher("Samsung", "QLED", 55);
        Geraet smartphone = new Smartphone("Apple", "iPhone 13", "iOS");
        Geraet laptop = new Laptop("Dell", "XPS 15", "Intel i7");

        // Testen der Geräte
        System.out.println("Testing Fernseher:");
        mediaSuperMarkt.testGeraet(fernseher);

        System.out.println("\nTesting Smartphone:");
        mediaSuperMarkt.testGeraet(smartphone);

        System.out.println("\nTesting Laptop:");
        mediaSuperMarkt.testGeraet(laptop);
    }
}
