package lab_4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("type a interval starting point must be > 0 ");
        int startInterval = Integer.parseInt(userInput.nextLine());

        System.out.print("type a interval ending point ");
        int endInterval = Integer.parseInt(userInput.nextLine());

        int randomNr = (int) ((Math.random() * (endInterval - startInterval + 1) + startInterval));
        String userGuess;
        int nrOfGuesses = 0;
        boolean correctGuess = false;

        System.out.println("Please Guess the number i´m thinking of or <exit> to quit");
        do {
            System.out.print("Guess> ");
            userGuess = userInput.nextLine();
            nrOfGuesses++;
            try {
                int tempGuess = Integer.parseInt(userGuess);

                if (tempGuess < startInterval || tempGuess > endInterval) {
                    System.out.println("Your guess is outside the defined interval of " + startInterval + " - " + endInterval);
                } else if (tempGuess == randomNr) {
                    System.out.println("you guessed the correct nr in " + nrOfGuesses + " tries, i was thinking of the nr " + randomNr);
                    correctGuess = true;
                } else if (tempGuess < randomNr) {
                    System.out.println("your guess is too low");
                } else if (tempGuess > randomNr) {
                    System.out.println("your guess is too high");
                }
            } catch (Exception e) {
                if (userGuess.equals("exit")) {
                    System.out.println("You exited the program");
                    correctGuess = true;
                }
                else {
                    System.out.println("Unknown command");
                }
            }
        } while (!correctGuess);
    }
}
