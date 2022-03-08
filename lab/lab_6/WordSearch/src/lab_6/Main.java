package lab_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final String PROMPT_STR = "Enter the word to search for>";
    private static int fileLineCount = 0;
    private static long searchTime = 0;
    private static String inputFile = "wordlist1.txt";
    private static final Scanner keyboardIn = new Scanner(System.in);

    public static void main(String[] args) {

        if (args.length == 1) {
            inputFile = args[0];
        } else if (args.length > 1) {
            System.out.println("Too manny arguments");
            System.exit(0);
        }

        System.out.print(PROMPT_STR);
        String userInput = keyboardIn.nextLine();

        try {
            boolean foundWord = readAndSearchFile(userInput, inputFile);

            System.out.println("The file " + inputFile + " contins " + fileLineCount + " words");
            if (foundWord) {
                System.out.println("The word \"" + userInput + "\" was found in " + inputFile);
            } else {
                System.out.println("The word \"" + userInput + "\" was NOT found in " + inputFile);
            }
            System.out.println("The search took " + searchTime + " ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean readAndSearchFile(String word, String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileReader = new Scanner(file);

        String tempWord;
        boolean foundWord = false;

        long startTime = System.currentTimeMillis();
        long endTimeFound = 0, endTimeNotFound;

        while (fileReader.hasNextLine()) {
            tempWord = fileReader.nextLine();

            if (tempWord.equals((word))) {
                foundWord = true;

                endTimeFound = System.currentTimeMillis();
            }
            fileLineCount++;
        }
        endTimeNotFound = System.currentTimeMillis();
        searchTime = foundWord ? (endTimeFound - startTime) : (endTimeNotFound - startTime);
        return foundWord;
    }
}
