package DAY7_2_7_2024.javaMethoden;

// In dieser Aufgabe sollst du eine Methode aus der Java-Standardbibliothek selbst implementieren:

// ```java int compareTo(String s1,String s2)```

// -die Methode vergleicht String s1 mit einem anderen String s2-die Methode gibt einen negativen Wert zurück,wenn s2 vor s1 kommt,0,wenn beide Strings gleich sind und einen positiven Wert,wenn s2 nach s1 kommt
public class ImplementiereCompareTo {
    public static void main(String[] args) {
        ImplementiereCompareTo implementiereCompareTo = new ImplementiereCompareTo();

        implementiereCompareTo.compareTo("aaaa", "aa");
        implementiereCompareTo.compareTo("aa", "aaaa");
        implementiereCompareTo.compareTo("abc", "ABC");
        implementiereCompareTo.compareTo("ABC", "abc");
    }

    private int compareTo(String string1, String string2) {
        char[] charString1 = string1.toCharArray();
        char[] charString2 = string2.toCharArray();

        int minLength = Math.min(charString1.length, charString2.length);
        int i = 0;

        do {
            if (charString1[i] != charString2[i]) {
                System.out.println(charString1[i] - charString2[i]);
                return charString1[i] - charString2[i];
            }
            i++;
        } while (i < minLength);

        // If all characters are the same up to minLength, compare lengths
        System.out.println(charString1.length - charString2.length);
        return charString1.length - charString2.length;
    }
}

// private int compareTo(String string1, String string2) {
// char[] charString1 = string1.toCharArray();
// char[] charString2 = string2.toCharArray();

// if (string1.equals(string2)) {
// return 0;
// } else {
// int length1 = charString1.length;
// int length2 = charString2.length;
// if (length1 - length2 != 0) {
// System.out.println(length1 - length2);
// return length1 - length2;
// } else {
// System.out.println((int) (charString1[0] - charString2[0]));
// return (int) (charString1[0] - charString2[0]);
// }
// }
// }
