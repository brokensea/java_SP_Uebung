package DAY10_5_7_2024.javaMethoden;

import java.util.Arrays;
import java.util.stream.Collectors;

// Sich ein neues Passwort auszudenken,ist meistens eine knifflige Aufgabe.Viele Menschen wählen ihre Passwörter nach den Anfangsbuchstaben eines Satzes oder einer Zeile aus ihrem Lieblingslied,sodass sie es sich leicht merken können.Zum Beispiel:Das Erlernen von Java macht so viel Spass->DEvJmsvS ​

// Wir wollen uns eine Methode getPassword(String satz)schreiben,das uns derartige Passwörter generiert,wenn wir einen entsprechenden Satz eingeben.Nutze String-Methoden,um den übergebenen Satz in seine Wörter zu zerlegen.Welche String-Methode benötigst du dafür und welchen Datentyp bekommst du zurück?Erstelle dir außerdem einen leeren Passwort-String.Diesen füllst du später Stück für Stück mit den gesuchten Buchstaben auf.Bonus:Schreibe eine weitere Methode getStrongerPassword(String satz),wobei jetzt die Endbuchstaben der jeweiligen Wörter für das Passwort genutzt werden.Außerdem soll bei Buchstaben pro Zeichen zwischen Groß-und Kleinschreibung gewechselt werden.Das Erlernen von Java macht so viel Spass->SnNaToLs

public class PasswortGenerator {

    public static void main(String[] args) {
        // Das Erlernen von Java macht so viel Spass -> DEvJmsvS
        PasswortGenerator passwortGenerator = new PasswortGenerator();
        String input = "Das Erlernen von Java macht so viel Spass";
        String outputFirst = passwortGenerator.passwordsInitialFirstLetters(input);
        String outputLast = passwortGenerator.passwordsInitialLastLetters(input);

        System.out.println(outputFirst);
        // System.out.println(outputLast);
        System.out.println(passwortGenerator.getStrongerPassword(outputLast));
        
        

    }

    private String passwordsInitialFirstLetters(String input) {
        return Arrays.stream(input.split(" "))
                .filter(word -> !word.isEmpty()) // filter
                .map(word -> String.valueOf(word.charAt(0))) // get vale
                .collect(Collectors.joining()); // +=

        // String[] inputString = input.split(" ");
        // //System.out.print(Arrays.toString(inputString));
        // Arrays.forEach(inputString)-> input.atChat(0)++
        // return "";
    }

    private String passwordsInitialLastLetters(String input) {
        return Arrays.stream(input.split(" "))
                .filter(word -> !word.isEmpty()) // filter
                .map(word -> String.valueOf(word.charAt(word.length() - 1))) // get vale
                .collect(Collectors.joining()); // +=
    }

    private String getStrongerPassword(String password) {
        StringBuilder strongerPassword = new StringBuilder();
        boolean upper = true;
        for (char c : password.toCharArray()) {
            if (upper) {
                strongerPassword.append(Character.toUpperCase(c));
            } else {
                strongerPassword.append(Character.toLowerCase(c));
            }
            upper = !upper; // change
        }
        return strongerPassword.toString();
    }
}
