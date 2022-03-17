package PersonList;

import java.util.*;

/**
 * Menu class manages function calls of the menu choices and holds the main list the program operates on
 */
public class Menu {

    private final String SAVE_FILE = "personList.txt";
    private final String SAVE_FILE_ENCODED = "personListCesar.txt";
    private final Scanner keyboardIn = new Scanner(System.in);

    private final List<Person> personList = new ArrayList<>();

    //Printable ascii characters 32 - 126
    //number of characters in range 126-32 = 94
    //space nr 32
    //tilde ~ nr 126
    Cipher cipher = new Cipher(' ', '~');

    /**
     * creates a menu objects and starts the menu loop
     */
    Menu() {
        start();
    }

    /**
     * prints out the menu options and the size of the main list to screen
     */
    public void printMenu() {
        final String[] MENU_TEXT = {"""
1. add         lägga till en person
2. print       skriva ut listan med personer på skärmen
3. search      söka en person i listan
4. remove      ta bort en person från listan
5. sortN       sortera på namn
6. sortSig     sortera på signatur
7. sortH       sortera på längd
8. shuffle     slumpa ordningen
9. save        spara listan i en textfil.
10. read       läsa listan från en textfil.
0. quit, q     avsluta"""};
        final String PROMPT = "Input>";
        for (String option : MENU_TEXT) {
            System.out.println(option);
        }
        PersonListSize();
        System.out.print(PROMPT);
    }

    /**
     * prints the menu options and starts the menu loop
     */
    public void start() {
        final String ADD = "add";
        final String PRINT = "print";
        final String SEARCH = "search";
        final String REMOVE = "remove";
        final String SORT_NAME = "sortN";
        final String SORT_SIGNATURE = "sortSig";
        final String SORT_HEIGHT = "sortH";
        final String SHUFFLE = "shuffle";
        final String SAVE = "save";
        final String READ = "read";
        final String QUIT = "quit";
        final String Q = "q";

        boolean run = true;
        do {
            printMenu();

            String userInput = keyboardIn.nextLine();

            switch (userInput) {
                case "1", ADD -> add();
                case "2", PRINT -> print();
                case "3", SEARCH -> search();
                case "4", REMOVE -> remove();
                case "5", SORT_NAME ->
                        //sortByName
                        sort(new ComparePersonName());
                case "6", SORT_SIGNATURE ->
                        //sortBySignature
                        sort(new ComparePersonSignature());
                case "7", SORT_HEIGHT ->
                        //sortByHeight
                        sort(new ComparePersonHeight());
                case "8", SHUFFLE -> shuffle();
                case "9", SAVE -> saveListToFile();
                case "10", READ -> readFromFile();
                case "0", QUIT, Q -> terminate();
                default -> System.out.println("Invalid option try again");
            }
        } while (run);
    }

    /**
     * terminates the program
     */
    private void terminate() {
        System.out.println("Stopping");
        System.exit(0);
    }

    /**
     * prints out the current size of the main list with description text
     */
    private void PersonListSize() {
        System.out.println("Number of persons in current list: " + personList.size());
    }

    /**
     * creates and a person object from user keyboard input
     * checks if the new person is unique or not in the main list
     * @return a new person object
     */
    public Person inputMakePerson() {
        String forename;
        String surname;
        int height;
        boolean redoPerson;
        do {


            System.out.print("Forename: ");
            forename = keyboardIn.nextLine();
            System.out.print("Surname: ");
            surname = keyboardIn.nextLine();

            System.out.print("Height in cm: ");
            height = Integer.parseInt(keyboardIn.nextLine());

            if (!PersonListModifier.isUniquePerson(forename, surname, height, personList)) {
                System.out.println("person already exists, redo <y/n>");
                String choice = keyboardIn.nextLine();
                if (choice.compareToIgnoreCase("y") == 0) {
                    redoPerson = true;
                } else {
                    return null;
                }
            } else {
                redoPerson = false;
            }
        } while (redoPerson);


        System.out.print("Postal address: ");
        String postalAddress = keyboardIn.nextLine();
        System.out.print("zip code: ");
        String zipCode = keyboardIn.nextLine();
        System.out.print("Post office: ");
        String postOffice = keyboardIn.nextLine();

        String signature = makeSignature(forename, surname);

        return new Person(forename, surname, height, signature, new Address(postalAddress, zipCode, postOffice));
    }

    /**
     * creates a new Person object from a String array containing all data needed for a new Person object
     * @param personString a String array with all components a person needs to be created
     * @return a new person object
     */
    public Person stringMakePerson(String[] personString) {
        return new Person(personString[0], personString[1], Integer.parseInt(personString[3]), personString[2], new Address(personString[4], personString[5], personString[6]));
    }

    /**
     * creats a user signatues from a persons fore and surname
     * and adds a serial number to the end
     * @param forename a string reprecenting a persons name
     * @param surname a string reprecenting a persons surname
     * @return a user signature
     */
    public String makeSignature(String forename, String surname) {
        forename = forename.toLowerCase(Locale.ROOT);
        surname = surname.toLowerCase(Locale.ROOT);
        String IDPart1;
        String IDPart2;
        int numberOfOccurrences = 1;

        if (forename.length() <= 3) {
            IDPart1 = forename;
            //IDPart1 += forename.length() == 2 ? "x" : "xx";
            IDPart1 = String.format("%-3s", IDPart1).replace(' ', 'x');

        } else {
            IDPart1 = forename.substring(0, 3);
        }

        if (surname.length() <= 3) {
            IDPart2 = surname;
            //IDPart2 += surname.length() == 2 ? "x" : "xx";
            IDPart2 = String.format("%-3s", IDPart2).replace(' ', 'x');
        } else {
            IDPart2 = surname.substring(0, 3);
        }

        numberOfOccurrences += countOccurrencesOfID(IDPart1 + IDPart2);

        return IDPart1 + IDPart2 + String.format("%02d", numberOfOccurrences);
    }

    /**
     * couts how many times a given signature shows up in the main list
     * @param s a user signature
     * @return the number of times the signature was found
     */
    private int countOccurrencesOfID(String s) {
        int counter = 0;
        for (Person person : personList) {
            if (person.getSignature().contains(s)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * adds a new Persons object to the main list
     */
    public void add() {
        Person person = inputMakePerson();
        if (person != null) {
            personList.add(person);
        }
    }

    /**
     * calls a function to print the main list to screen
     */
    public void print() {
        PersonListModifier.printPersons(personList);
    }

    /**
     * searches the main list for a given signature with user input
     * and prints out if the signature was found or not,
     * if fount prints out the person the signature belongs to
     */
    public void search() {
        System.out.print("Signature: ");
        String searchTerm = keyboardIn.nextLine();

        int index = PersonListModifier.searchPerson(personList, searchTerm);
        if (index != -1) {
            System.out.println("Person found");
            personList.get(index).printPerson();
        } else {
            System.out.println("No person found with that signature");
        }
    }

    /**
     * searches the main list for a given signature with user input
     * and prints out that the person was removed if the signature was found or not
     */
    public void remove() {
        System.out.print("Signature: ");
        String searchTerm = keyboardIn.nextLine();

        boolean removed = PersonListModifier.removePerson(personList, searchTerm);
        if (removed) {
            System.out.println("person has been removed");
        } else {
            System.out.println("No person found with that signature to remove");
        }
    }

    /**
     * sorts the main list with a given comparator boject
     * @param comparator a comparator object to specify how to sort the list
     */
    public void sort(Comparator<Person> comparator) {
        PersonListModifier.sortPersons(personList, comparator);
    }

    /**
     * shuffles the main list
     */
    public void shuffle() {
        PersonListModifier.shuffle(personList);
    }

    /**
     * saves the main list to file encrypted
     */
    private void saveListToFile() {
        System.out.print("specify a encryption key between 0 to 95: ");
        int encryptionKey = Integer.parseInt(keyboardIn.nextLine());

        StringBuilder personListStr = new StringBuilder();
        for (Person person : personList) {
            personListStr.append(cipher.caesar(person.toSerial(), encryptionKey)).append('\n');
        }

        PersonListReadWrite.writeToFile(personListStr.toString(), SAVE_FILE_ENCODED);
    }

    /**
     * read a file with encrypted person strings and decodes and makes person objects from the strings and adds the new persons to the list
     */
    private void readFromFile() {
        System.out.print("specify a decryption key between 0 to 95: ");
        int encryptionKey = Integer.parseInt(keyboardIn.nextLine());

        List<String> tempList = PersonListReadWrite.readAllFromFile(SAVE_FILE_ENCODED);
        personList.clear();

        for (String line : tempList) {
            //using cyclic nature of the caesar cipher to decode taking the number if chars - the key to get back to the starting char
            String decryptedString = cipher.caesar(line, cipher.getRangeCount() - encryptionKey);
            personList.add(stringMakePerson(decryptedString.split("\\|")));
        }
    }
}
