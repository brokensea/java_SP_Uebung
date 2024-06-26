package DAY3_26_6_2026.javaKontrollstrukturen;

// Schreibe ein Programm:
// -das die Summe der Zahlen von 1 bis 100 berechnet und ausgibt-das die Summer aller geraden Zahlen von 1 bis 100 berechnet und ausgibt-das die Summer aller ungeraden Zahlen von 1 bis 100 berechnet und ausgibt
public class ZahlenreiheAusgeben {
    public static void main(String[] args) {
        ZahlenreiheAusgeben zahlenreiheAusgeben = new ZahlenreiheAusgeben();
        zahlenreiheAusgeben.rechnenSumme();
    }

    private void rechnenSumme() {
        int summe1_100 = 0;
        int summeGeradenZahlen1_100 = 0;
        int summeUngeradenZahlen1_100 = 0;
        for (int i = 0; i <= 100; i++) {
            summe1_100 += i;
            if (i % 2 == 0) {
                summeGeradenZahlen1_100 += i;
            } else {
                summeUngeradenZahlen1_100 += i;
            }
        }
        System.out.println("summe ist: " + summe1_100);
        System.out.println("summeGeradenZahlen1_100 ist: " + summeGeradenZahlen1_100);
        System.out.println("summeUngeradenZahlen1_100 ist: " + summeUngeradenZahlen1_100);
    }
}
