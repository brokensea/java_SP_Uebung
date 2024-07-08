package DAY11_8_7_2024.javaOOP.kunde;
// **Erstellung der Klasse:**

// -Erstelle eine Klasse`Kunde`,die die Attribute`kundenId`,`name`,`email`und`telefonnummer`hat-Implementiere einen Konstruktor,der diese Attribute initialisiert-Füge Getter-und Setter-Methoden für jedes Attribut hinzu-Implementiere eine Methode`printDetails`,die die Details des Kunden auf der Konsole ausgibt

// **Verwendung der Klasse:**

// -erstelle eine weitere Klasse Kundenverwaltung,die eine main-Methode enthält-in der main-Methode sollen mindestens drei Kunden angelegt werden

// **Konstruktor:**

// -ein Konstruktor,der nur`kundenId`und`name`initialisiert,während`email`und`telefonnummer`leer sind-ein Konstruktor,der`kundenId`,`name`und`email`initialisiert,während`telefonnummer`leer ist-prüfe deine Konstruktoren,indem du weitere Kunden in der main-Methode anlegst
public class Kunde {

    private int kundenId;
    private String name;
    private String email;
    private int telefonnummer;

    public Kunde(int kundenId, String name, String email, int telefonnummer) {
        this.setKundenId(kundenId);
        this.setName(name);
        this.setEmail(email);
        this.setTelefonnummer(telefonnummer);
    }

    public Kunde(int kundenId, String name) {
        this.setKundenId(kundenId);
        this.setName(name);
        this.setEmail("email leehr");
        this.setTelefonnummer(0);
    }

    public Kunde(int kundenId, String name, String email) {
        this.setKundenId(kundenId);
        this.setName(name);
        this.setEmail(email);
        this.setTelefonnummer(0);
    }

    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundenId=" + kundenId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telefonnummer=" + telefonnummer +
                '}';
    }

    public void printDetails() {
        System.out.println(this.toString());
    }

}
