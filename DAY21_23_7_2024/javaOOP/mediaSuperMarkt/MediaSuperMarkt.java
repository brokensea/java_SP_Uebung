package DAY21_23_7_2024.javaOOP.mediaSuperMarkt;

public class MediaSuperMarkt {

    public void testGeraet(Geraet geraet) {
        geraet.einschalten();
        if (geraet instanceof Bluetoothfaehig) {
            ((Bluetoothfaehig) geraet).verbindenMitBluetooth();
        }
        if (geraet instanceof Internetfaehig) {
            ((Internetfaehig) geraet).verbindenMitInternet();
        }
        geraet.anzeigen();
        geraet.ausschalten();
    }

}

class Geraet {
    protected String marke;
    protected String modell;

    public Geraet(String marke, String modell) {
        this.marke = marke;
        this.modell = modell;
    }

    public void einschalten() {
        System.out.println(this.marke + " " + this.modell + "wird eingeschaltet");
    }

    public void ausschalten() {
        System.out.println(this.marke + " " + this.modell + "wird ausgeschaltet");
    }

    @Override
    public String toString() {
        return "Geraet [marke=" + marke + ", modell=" + modell + "]";
    }

    public void anzeigen() {
        System.out.println(this.toString());
    }

}

class Fernseher extends Geraet implements Bluetoothfaehig {
    private int bildschirmgroesse;

    public Fernseher(String marke, String modell, int bildschirmgroesse) {
        super(marke, modell);
        this.bildschirmgroesse = bildschirmgroesse;
    }

    @Override
    public String toString() {
        return super.toString() + ", bildschirmgroesse=" + bildschirmgroesse + " ]";
    }

    @Override
    public void verbindenMitBluetooth() {
        System.out.println(this.marke + " " + this.modell + " " + "mit einem Bluetooth-Gerät verbunden wird");
    }

}

class Smartphone extends Geraet implements Internetfaehig, Bluetoothfaehig {
    private String betriebsystem;

    public Smartphone(String marke, String modell, String betriebsystem) {
        super(marke, modell);
        this.betriebsystem = betriebsystem;
    }

    @Override
    public void verbindenMitBluetooth() {
        System.out.println(this.marke + " " + this.modell + " " + "mit einem Bluetooth-Gerät verbunden wird");
    }

    @Override
    public void verbindenMitInternet() {
        System.out.println(this.marke + " " + this.modell + " " + "mit dem Internet  verbunden wird");
    }

    @Override
    public String toString() {
        return super.toString() + ", betriebsystem=" + betriebsystem + "]";
    }

}

class Laptop extends Geraet implements Internetfaehig {
    private String prozessor;

    public Laptop(String marke, String modell, String prozessor) {
        super(marke, modell);
        this.prozessor = prozessor;

    }

    @Override
    public void verbindenMitInternet() {
        System.out.println(this.marke + " " + this.modell + " " + "mit dem Internet  verbunden wird");

    }

    @Override
    public String toString() {
        return super.toString() + ", prozessor=" + prozessor + "]";
    }

}

// #Aufgabenstellung
// ###Elektronische Geräte
// Erstelle ein Programm,das die Konzepte von Vererbung,Polymorphie und
// Interfaces in Java demonstriert.

// 1.**Basisklasse`Geraet`**:
// -Eigenschaften:-`marke`(String)-`modell`(String)-Methoden:-`einschalten()`:Gibt
// aus,dass das Gerät eingeschaltet wird.-`ausschalten()`:Gibt aus,dass das
// Gerät ausgeschaltet wird.-`anzeigen()`:Gibt die Marke und das Modell des
// Geräts aus.

// 2.**Unterklassen`Fernseher`,`Smartphone`und`Laptop`**:-Erstellen Sie die
// Klasse`Fernseher`,die von`Geraet`erbt,mit einer zusätzlichen
// Eigenschaft`bildschirmgroesse`(int).-Erstellen Sie die Klasse`Smartphone`,die
// von`Geraet`erbt,mit einer zusätzlichen
// Eigenschaft`betriebsystem`(String).-Erstellen Sie die Klasse`Laptop`,die
// von`Geraet`erbt,mit einer zusätzlichen Eigenschaft`prozessor`(String).

// 1.**Polymorphe Methode`testGeraet(Geraet g)`**:-Diese Methode akzeptiert ein
// beliebiges`Geraet`,schaltet es ein,zeigt die Details des Geräts an und
// schaltet es wieder aus.

// 1.**Interface`Internetfaehig`**:-Methode`verbindenMitInternet()`:Gibt
// aus,dass das Gerät mit dem Internet verbunden wird

// 2.**Interface`Bluetoothfaehig`**:-Methode`verbindenMitBluetooth()`:Gibt
// aus,dass das Gerät mit einem Bluetooth-Gerät verbunden wird

// 3.**Implementierung der Interfaces**:-die Klasse`Smartphone`soll sowohl das
// Interface`Internetfaehig`als auch`Bluetoothfaehig`implementieren-die
// Klasse`Laptop`soll das Interface`Internetfaehig`implementieren-die
// Klasse`Fernseher`soll das Interface`Bluetoothfaehig`implementieren

// ###Main→🌲 🌳 🌴 Spielwiese🌲 🌳 🌴→ihr wisst bescheid😉