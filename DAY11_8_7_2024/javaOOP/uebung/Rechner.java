package DAY11_8_7_2024.javaOOP.uebung;

public class Rechner {
    private int maximalErreichbarenPunkte = 0;
    private int erreichtenPunkte = 0;
    private double prozentualenErreichtenPunkte = 0;

    public static void main(String[] args) {
        Rechner rechner = new Rechner();
        rechner.init();
        System.out.println(rechner.toString());
    }

    private void init() {
        Uebungsblatt[] uebungsblattArray = new Uebungsblatt[13];
        for (int i = 0; i < uebungsblattArray.length; i++) {
            uebungsblattArray[i] = new Uebungsblatt(i, 60, (int) (Math.random() * 61));
        }

        // Variablen zur Speicherung des Übungsblatts mit maximalen und minimalen
        // Punktzahlen initialisieren
        Uebungsblatt maxBlatt = uebungsblattArray[0];
        Uebungsblatt minBlatt = uebungsblattArray[0];

        for (Uebungsblatt u : uebungsblattArray) {
            u.printDetails();
            this.erreichtenPunkte += u.getErreichtePunkten();
            this.maximalErreichbarenPunkte += u.getMaximalePunkten();

            // Überprüfen, Max und Min
            if (u.istHoechstesBlatt(maxBlatt)) {
                maxBlatt = u;
            }
            if (u.istNiedrigstesBlatt(minBlatt)) {
                minBlatt = u;
            }

        }
        this.prozentualenErreichtenPunkte = (double) this.erreichtenPunkte / (double) this.maximalErreichbarenPunkte;

        System.out.println("Übungsblatt mit der höchsten Punktzahl:");
        System.out.println(maxBlatt.toString());
        System.out.println("Übungsblatt mit der niedrigsten Punktzahl:");
        System.out.println(minBlatt.toString());
    }

    @Override
    public String toString() {
        return "Rechner{" +
                "maximalErreichbarenPunkte=" + maximalErreichbarenPunkte +
                ", erreichtenPunkte=" + erreichtenPunkte +
                ", prozentualenErreichtenPunkte=" + prozentualenErreichtenPunkte +
                '}';
    }

}
