package DAY13_10_7_2024.autoPackage;

public class Fahrer {
    private String vorname;
    private String nachname;
    private int alter;

    public Fahrer(String vorname, String nachname, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    public boolean fahren(Auto auto, int kilometer) {
        if (this.alter < 18) {
            throw new IllegalStateException(" Alter kleiner als 18, darf nicht fahren.");
        }
        if (kilometer < 0) {
            throw new IllegalArgumentException(" kilometer < 0 nicht erlaubt");
        }
        if (auto.getTankinhalt() < kilometer * auto.getVerbrauch()) {
            throw new IllegalArgumentException(" Tankinhalt nicht ausreichend");
        }
        auto.addKilometerstand(kilometer);

        return true;
    }
}
