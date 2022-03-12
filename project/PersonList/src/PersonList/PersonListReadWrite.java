package PersonList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonListReadWrite {
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

    public static List<String> readFromFile(String fileName) {
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
