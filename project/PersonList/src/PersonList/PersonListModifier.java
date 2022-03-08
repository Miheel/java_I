package PersonList;

import java.util.*;

public class PersonListModifier {

    public static void printPersons(List<Person> personList) {
        System.out.format("%s %-10s %-20s %s\n", "Nr", "Sign", "Name", "Length[m]");
        for (int i = 0; i < personList.size(); i++) {
            System.out.printf("%2s ", i + 1);
            personList.get(i).printPerson();
        }
    }

    public static int searchPerson(List<Person> personList, String searchTerm) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getSignature().equals(searchTerm)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean removePerson(List<Person> personList, String searchTerm) {
        int index = searchPerson(personList, searchTerm);

        if (index != -1) {
            personList.remove(index);
            return true;
        }
        return false;
    }

    public static void sortPersons(List<Person> personList, Comparator comparator) {
        personList.sort(comparator);
    }

    public static void shuffle(List<Person> personList) {
        Random rand = new Random();
        for (int i = 0; i < personList.size(); i++) {
            int randIndex = rand.nextInt(personList.size());
            swap(personList, i, randIndex);
        }
    }

    public static void swap(List<Person> personList, int i1, int i2) {
        Person temp = personList.get(i1);
        personList.set(i1, personList.get(i2));
        personList.set(i2, temp);
    }
}
