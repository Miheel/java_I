package lab_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String MAD_LIB = "Den lilla myran %s \n" +
            "Det var en gång en liten, liten myra som bodde med sin %s och sina %s syskon i en myrstack, \n" +
            "vid en stor %s i skogen. Den lilla myran hette %s. \n" +
            "För det mesta brukade %s och hans syskon arbeta med att bära in %s och %s till stacken, \n" +
            "men idag var det %s, så därför var %s ledig.\n";

    public static final ArrayList<String> WORD_QUESTIONS = new ArrayList<String>(Arrays.asList(
            "Namnet på myran? ",
            "Vem myran bor med? ",
            "Hur många syskon som myran har? ",
            "Var någonstans i skogen myrstacken finns? ",
            "Vad myran och syskonen bär in till stacken? ",
            "Vad myran och syskonen mer bär in till stacken? ",
            "Vad det är för speciell dag som gör att myran är ledig? "));


    public static void main(String[] args) {

        Scanner keyboardIn = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        String antName, liveWith, nrOfSiblings, whereAnthill, carryToAnthill1, carryToAnthill2, spacialDay;

        for (String question : WORD_QUESTIONS) {
            System.out.print(question);
            answers.add(keyboardIn.next());
        }

        antName = answers.get(0);
        liveWith = answers.get(1);
        nrOfSiblings = answers.get(2);
        whereAnthill = answers.get(3);
        carryToAnthill1 = answers.get(4);
        carryToAnthill2 = answers.get(5);
        spacialDay = answers.get(6);

        System.out.println();
        System.out.format(MAD_LIB, antName, liveWith, nrOfSiblings, whereAnthill, antName, antName, carryToAnthill1, carryToAnthill2, spacialDay, antName);
    }
}
