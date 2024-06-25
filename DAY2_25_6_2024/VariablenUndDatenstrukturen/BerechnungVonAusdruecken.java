package DAY2_25_6_2024.VariablenUndDatenstrukturen;

public class BerechnungVonAusdruecken {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int c = 6;
        double x = 1.5;
        double y = 2.3;
        int int_ergebnis;
        double double_ergebnis;

        int_ergebnis = c - a * 3; // -3
        System.out.println(int_ergebnis);
        int_ergebnis = c / a; // 2
        System.out.println(int_ergebnis);
        int_ergebnis = c / b; // 1
        System.out.println(int_ergebnis);
        int_ergebnis = a + b / c; // 3
        System.out.println(int_ergebnis);
        // int a = 5;
        // int b = a++; // b = 5, a = 6
        int_ergebnis = a++; // 3
        System.out.println(int_ergebnis);
        // int a = 5;
        // int b = ++a; // b = 6, a = 6
        int_ergebnis = ++a; // 5
        System.out.println(int_ergebnis);
        int_ergebnis = b + a--; // 10
        System.out.println(int_ergebnis);
        int_ergebnis = b + --a; // 8
        System.out.println(int_ergebnis);
        // int_ergebnis = a**; //error
        double_ergebnis = c / b; // 1.0
        System.out.println(double_ergebnis);
        double_ergebnis = x + y * b; // 13.0
        System.out.println(double_ergebnis);
        double_ergebnis = (x + y) * b; // 19.0
        System.out.println(double_ergebnis);
        double_ergebnis = c + a / b; // 6.0
        System.out.println(double_ergebnis);
        double_ergebnis = (x * c - a); // 6.0
        System.out.println(double_ergebnis);

    }
}