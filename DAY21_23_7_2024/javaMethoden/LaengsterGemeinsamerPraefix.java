package DAY21_23_7_2024.javaMethoden;

public class LaengsterGemeinsamerPraefix {

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs)); // Output: "fl"
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // basierend auf der ersten Zeichenfolge
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Kürzen das Präfix weiter, bis es zum Präfix von strs[i] wird.

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}

// # Aufgabenstellung

// Schreibe eine Methode `longestCommonPrefix`, die den längsten gemeinsamen
// Präfix für eine Liste von Strings findet.

// public static void main(String[] args) {
// String[] strs = {"flower", "flow", "flight"};
// System.out.println(longestCommonPrefix(strs)); // Output: "fl"
// }