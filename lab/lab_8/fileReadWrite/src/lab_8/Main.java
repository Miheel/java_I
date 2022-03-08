package lab_8;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner keyboardIn = new Scanner(System.in);
    private static final String PROMPT = "To which file should the result be saved? ";

    public static void main(String[] args) {

        List<String> allLines = PopulationReadWrite.readFileAllLines(Path.of("befolkning2050.txt"));

        Population pop = new Population();
        pop.calculatePop(allLines);
        List<String> populationList = PopulationReadWrite.prettify(pop.getPopulationPairList());

        System.out.print(PROMPT);
        String outFile = keyboardIn.nextLine();

        PopulationReadWrite.writeListToFile(Path.of(outFile), populationList);

        PopulationReadWrite.printPopulation(populationList);



        Pair<String, Integer> pair = new Pair<>("string", 2);
    }
}
