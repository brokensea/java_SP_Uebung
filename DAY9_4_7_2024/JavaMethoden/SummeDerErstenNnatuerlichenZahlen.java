package DAY9_4_7_2024.JavaMethoden;

//Sum of the first n natural numbers
// Implementiere eine rekursive Methode in Java,die die Summe der ersten n natürlichen Zahlen berechnet.Die Methode soll einen Parameter n,die Anzahl der natürlichen Zahlen,akzeptieren und deren Summe berechnen und zurückgeben.
public class SummeDerErstenNnatuerlichenZahlen {
    public static void main(String[] args) {
        SummeDerErstenNnatuerlichenZahlen summeDerErstenNnatuerlichenZahlen = new SummeDerErstenNnatuerlichenZahlen();

        System.out.println(summeDerErstenNnatuerlichenZahlen.sumNaturalNumber(3));
    }

    /**
     * Sum of the first n natural numbers
     * 
     * @param number
     * @return int
     */
    private int sumNaturalNumber(int number) {
        if (number <= 0) {
            return 0;
        }
        return number + sumNaturalNumber(number - 1);
    }
}
