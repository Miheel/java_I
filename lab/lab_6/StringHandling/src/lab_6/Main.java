package lab_6;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static final String PROMPT_STR = "Enter some text>";
    private static Scanner keyboardIn = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print(PROMPT_STR);
            String userInput = keyboardIn.nextLine();

            StringTokenizer tokens = new StringTokenizer(userInput, ".!?");

            String[] words = userInput.split(" ");

            System.out.println("Sentences: " + tokens.countTokens());
            System.out.println("Words: " + words.length);
            System.out.println("Characters: " + userInput.length());
        }
    }
}
