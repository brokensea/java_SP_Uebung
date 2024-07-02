package DAY7_2_7_2024.javaMethoden;

// In dieser Aufgabe sollst du die Methode substring aus der Java-Standardbibliothek selbst implementieren:

// ```java String substring(String str,int start,int end)```

// -die substring-Methode extrahiert einen Teilstring aus einem gegebenen String-die Methode gibt den Teilstring von der Position start(inklusive)bis end(exklusive)zurück-wenn start oder end ungültige Werte haben,soll die Methode null zurückgeben
public class ImplementiereSubstring {
    public static void main(String[] args) {

        ImplementiereSubstring implementiereSubstring = new ImplementiereSubstring();
        // implementiereSubstring.substring("null", 2);

        System.out.println(implementiereSubstring.substring("Hello, World!", 7)); // : "World!"
        System.out.println(implementiereSubstring.substring("abcdef", 3)); // : "def"

        System.out.println(implementiereSubstring.substring("Hello, World!", 7, 11)); // : "Worl"
        System.out.println(implementiereSubstring.substring("abcdef", 2, 4)); // : "cd"
    }

    private String substring(String input, int index) {
        if (index < 0 || index > input.length()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + input.length());
        }

        char[] stringToCharArry = input.toCharArray();
        StringBuilder output = new StringBuilder();
        for (int indexJ = index; indexJ < stringToCharArry.length; indexJ++) {
            output.append(stringToCharArry[indexJ]);
        }
        return output.toString();

    }

    private String substring(String input, int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > input.length() || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException(
                    "beginIndex: " + beginIndex + ", endIndex: " + endIndex + ", Length: " + input.length());
        }

        char[] stringToCharArry = input.toCharArray();
        StringBuilder output = new StringBuilder();

        for (int indexJ = beginIndex; indexJ < endIndex; indexJ++) {
            output.append(stringToCharArry[indexJ]);
        }
        return output.toString();
    }

}
