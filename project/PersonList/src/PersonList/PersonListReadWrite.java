package PersonList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * read and write text too and from files
 */
public class PersonListReadWrite {

    /**
     * writes a string to a file
     * @param str the string to be written to file
     * @param fileName the filname of the out file
     */
    public static void writeToFile(String str, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(List<Person> list, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            for (Person person : list) {

                fileWriter.write(person.toSerial());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads all lines from a file
     * @param fileName the filname of the file to read
     */
    public static List<String> readAllFromFile(String fileName) {
        List<String> temp = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(new FileReader(fileName));
            while (fileReader.hasNext())
            {
               temp.add(fileReader.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
