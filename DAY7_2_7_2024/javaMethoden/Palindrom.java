package DAY7_2_7_2024.javaMethoden;

import java.util.Arrays;

// Schreibe eine Methode,die überprüft,ob ein eingegebenes Wort oder eine Zahl ein Palindrom ist.

// **Definition Palindrom:**ist ein Wort,Satz,eine Zahl oder eine andere Zeichenfolge,die vorwärts und rückwärts identisch ist,wenn man die Buchstaben oder Zeichen umdreht.

// -Amok Oma-Ein Esel lese nie-Anna-Lagerregal

public class Palindrom {
    public static void main(String[] args) {
        Palindrom palindrom = new Palindrom();
        System.out.println(palindrom.reverse("1234"));

        System.out.println(palindrom.isPalindrom("Anna"));

        System.out.println(palindrom.isPalindrom("Amok Oma")); // fals
        System.out.println(palindrom.isPalindrom("Ein Esel lese nie"));
        System.out.println(palindrom.isPalindrom("Lagerregal"));

    }

    private boolean isPalindrom(String inputString) {
        String lowercaseInput = inputString.toLowerCase();
        char[] stringToCharArray = lowercaseInput.toCharArray();
        char[] reverseStringToCharArray = reverse(lowercaseInput).toCharArray();
        return Arrays.equals(stringToCharArray, reverseStringToCharArray);
    }

    private String reverse(String input) {
        char[] arr = input.toCharArray();
        StringBuilder output = new StringBuilder();
        int length = arr.length;
        for (int indexI = length - 1; indexI >= 0; indexI--) {
            output.append(arr[indexI]);
        }
        return output.toString();
    }
}
