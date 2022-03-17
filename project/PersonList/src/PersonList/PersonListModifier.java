package PersonList;

import java.util.*;

/**
 * modifies and access a list with persons objects
 */
public class PersonListModifier {

    public static void printPersons(List<Person> personList) {
        System.out.format("%s %-10s %-20s %s\n", "Nr", "Sign", "Name", "Length[m]");
        for (int i = 0; i < personList.size(); i++) {
            System.out.printf("%2s ", i + 1);
            personList.get(i).printPerson();
        }
    }

    /**
     * searches a list for a given signature search term and return the index of the first found person
     *
     * @param personList a list containing Persons objects
     * @param searchTerm a person signature to search for
     * @return the index of the first found person with the given signature
     */
    public static int searchPerson(List<Person> personList, String searchTerm) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getSignature().equals(searchTerm)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * searches a list for a given signature search term and removes the first person found,
     *
     * @param personList a list containing Persons objects
     * @param searchTerm a person signature to search for
     * @return if the person was found and removed return true else return false
     */
    public static boolean removePerson(List<Person> personList, String searchTerm) {
        int index = searchPerson(personList, searchTerm);

        if (index != -1) {
            personList.remove(index);
            return true;
        }
        return false;
    }

    /**
     * sorts a list with comparator objects
     * @param personList a list containing person objects
     * @param comparator a comparator objects to compare person objects
     */
    public static void sortPersons(List<Person> personList, Comparator<Person> comparator) {
        personList.sort(comparator);
    }

    /**
     * checks if a given name AND height is unique in a list of persons
     * @param forename a string reprecenting persons forename
     * @param surname a string reprecenting persons forename
     * @param height a perons height in cm
     * @param personList a list with person objects
     * @return retrns true if the names and height does not equal any single person in the list return false if it does equal
     */
    public static boolean isUniquePerson(String forename, String surname, int height, List<Person> personList) {
        for (Person tempPerson : personList) {
            if ((forename.compareToIgnoreCase(tempPerson.getForename()) == 0) && (surname.compareToIgnoreCase(tempPerson.getSurname()) == 0) && (height == tempPerson.getHeightCM())) {
                return false;
            }
        }
        return true;
    }

    /**
     * shuffles a list with person objects
     * @param personList a list with person objects
     */
    public static void shuffle(List<Person> personList) {
        Random rand = new Random();
        for (int i = 0; i < personList.size(); i++) {
            int randIndex = rand.nextInt(personList.size());
            swap(personList, i, randIndex);
        }
    }

    /**
     * swaps two objects ina list with eachother
     * @param personList a list with persons
     * @param i1 a index of the list
     * @param i2 a index of the list
     */
    public static void swap(List<Person> personList, int i1, int i2) {
        Person temp = personList.get(i1);
        personList.set(i1, personList.get(i2));
        personList.set(i2, temp);
    }
}
