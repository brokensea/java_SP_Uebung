package DAY20_22_7_2024.javaMethoden;

import java.util.Scanner;

public class HangmanTest {
    public static void main(String[] args) {
        // Run Hangman
        Scanner scanner = new Scanner(System.in);
        Hangman hangman = new Hangman(scanner);
        hangman.run();
        scanner.close();
    }
}