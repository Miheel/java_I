package lab_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PopulationReadWrite {
    private static final String AGE_STR = "Age";
    private static final String QUANTITY_STR = "Quantity";
    private static final String SEPARATOR = "__________________";
    private static final String FILE_HEADER = String.format("%" + AGE_STR.length() + "s%" + (SEPARATOR.length() - AGE_STR.length()) + "s", AGE_STR, QUANTITY_STR);

    public static List<String> readFileAllLines(Path filePath) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeListToFile(Path filePath, List<String> lines) {
        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printPopulation(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void addHeaderFooter(List<String> lines) {
        lines.add(0, FILE_HEADER + "\n" + SEPARATOR);
        lines.add(lines.size() - 1, SEPARATOR);
    }

    public static List<String> prettify(List<Pair<String, String>> pairList){
        List<String> tempList = new ArrayList<>();
        for (Pair<String, String> pair: pairList) {
            String first = pair.getFirst();
            String second = pair.getSecond();

            int strLen = (first.length() > AGE_STR.length()) ? first.length() : AGE_STR.length();

            tempList.add(String.format("%" + strLen + "s%" + (SEPARATOR.length() - strLen) + "s", first, second));
        }
        addHeaderFooter(tempList);
        return tempList;
    }

}
