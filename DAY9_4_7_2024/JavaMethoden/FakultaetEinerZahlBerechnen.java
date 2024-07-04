package DAY9_4_7_2024.JavaMethoden;

//Calculate the power of a number
// Schreibe ein Java-Programm,das eine rekursive Methode*fakultaet(int n)*zur Berechnung der Fakultät enthält.
//Calculate the factorial of a number
// Die Fakultät der Zahl n bezeichnet man als n!und ist der Wert des Produktes aller natürlichen Zahlen von 1 bis n.
// n!=1*2*3...*n
// 0! = 1
public class FakultaetEinerZahlBerechnen {
    public static void main(String[] args) {
        FakultaetEinerZahlBerechnen fakultaetEinerZahlBerechnen = new FakultaetEinerZahlBerechnen();

        System.out.println(fakultaetEinerZahlBerechnen.calculateFactorial(5));
    }

    /**
     * n!=1*2*3...*n
     * 
     * @param number
     * @return int
     */
    private int calculateFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }
}
