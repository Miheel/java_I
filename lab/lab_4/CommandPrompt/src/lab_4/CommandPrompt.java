package lab_4;

import java.util.Scanner;

public class CommandPrompt {

    private static final String HELP_COMMAND = "help";
    private static final String Q_COMMAND = "q";
    private static final String QUIT_COMMAND = "quit";
    private static final String HELLO_COMMAND = "hello";
    private static final String ODD_COMMAND = "odd";
    private static final String REPEAT_COMMAND = "repeat";
    private static final String CALC_COMMAND = "calc";
    private static final String CALCULATE_COMMAND = "calculate";

    private static final String PROMPT = "input> ";
    private boolean quitProgram = false;
    private final Scanner keyboardIn = new Scanner(System.in);

    CommandPrompt(){
        start();
    }

    public void start() {
        do {
            System.out.print(PROMPT);
            String input = keyboardIn.nextLine();
            switch (input) {
                case HELP_COMMAND:
                    help();
                    break;

                case Q_COMMAND, QUIT_COMMAND:
                    quitProgram = quit();
                    break;

                case HELLO_COMMAND:
                    hello();
                    break;

                case ODD_COMMAND:
                    odd();
                    break;

                case REPEAT_COMMAND:
                    repeat();
                    break;

                case CALC_COMMAND, CALCULATE_COMMAND:
                    try{
                        calc();
                    }
                    catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    wrongCommandError(input);
                    help();
                    break;
            }
        } while (!quitProgram);
    }

    private void help() {
        System.out.println(
                "Available commands:\n" +
                "• help         Prints this help text\n" +
                "• q            Quit the program\n" +
                "• quit         Quit the program\n" +
                "• hello        Print greeting to screen\n" +
                "• odd          Check if a certain number is odd or even\n" +
                "• repeat       Repeat a given string a certain number of times\n" +
                "• calc         Perform a simple mathematical calculation\n" +
                "• calculate    Same as 'calc'");
    }

    private void odd() {
        System.out.print("pls input a number: ");
        int numberIn = Integer.parseInt(keyboardIn.nextLine());
        String outStr = "The number " + numberIn + " is ";
        System.out.println((numberIn % 2) == 0 ? outStr + "even" : outStr + "odd");
    }

    private boolean quit() {
        System.out.println("Exiting prompt");
        return true;
    }

    private void hello() {
        System.out.println("Hello world");
    }

    private void repeat() {
        System.out.print("Enter a string: ");
        String str = keyboardIn.nextLine();
        System.out.print("Enter how many times to print the string: ");
        int timesStr = Integer.parseInt(keyboardIn.nextLine());
        for (int i = 0; i < timesStr; i++) {
            System.out.println(i + " " + str);
        }
    }

    private void calc() {
        System.out.println("pls input two operands and one operator");
        System.out.print("Operand 1: ");
        double operand1 = Double.parseDouble(keyboardIn.nextLine());
        System.out.print("Operator : ");
        String operator = keyboardIn.nextLine();
        System.out.print("Operand 2: ");
        double operand2 = Double.parseDouble(keyboardIn.nextLine());


        double result = switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "/" -> operand1 / operand2;
            case "*" -> operand1 * operand2;
            default ->  throw new IllegalArgumentException("Unexpected operator: \'" + operator + "\'");
        };

        System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result);
    }

    private void wrongCommandError(String wrongCommand) {
        System.out.println("Coundn´t find the command \'" + wrongCommand + '\'');
    }
}
