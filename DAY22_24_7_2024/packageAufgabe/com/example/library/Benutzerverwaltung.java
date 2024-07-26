package DAY22_24_7_2024.packageAufgabe.com.example.library;

public class Benutzerverwaltung {

    public void setDarfAusleihen(Benutzer benutzer, boolean darfAusleihen) {
        if (benutzer.getBenutzerType() == BenutzerType.NormaleBenutzer) {
            benutzer.setDarfAusleihen(darfAusleihen);
            System.out.println("set" + " " + benutzer.getNameBenutzer() + " ausleihen Recht " + darfAusleihen);
        } else {
            System.out.println("Admini brauch kein ausleihen Recht ");
        }
    }

    public class Benutzer {
        private String nameBenutzer;
        private BenutzerType benutzerType;
        private boolean darfAusleihen;
        private Loan loan;

        public String getNameBenutzer() {
            return nameBenutzer;
        }

        public void setNameBenutzer(Benutzer nameBenutzer) {
            this.nameBenutzer = nameBenutzer.getNameBenutzer();
        }

        public BenutzerType getBenutzerType() {
            return benutzerType;
        }

        public void setBenutzerType(BenutzerType benutzerType) {
            this.benutzerType = benutzerType;
        }

        public boolean isDarfAusleihen() {
            return darfAusleihen;
        }

        public void setDarfAusleihen(boolean darfAusleihen) {
            this.darfAusleihen = darfAusleihen;
        }

        public Loan getLoan() {
            return loan;
        }

        public void setLoan(Loan loan) {
            this.loan = loan;
        }

    }
}
