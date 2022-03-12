package PersonList;

import java.util.*;

public class Menu {

    private final String SAVE_FILE = "personList.txt";
    private final Scanner keyboardIn = new Scanner(System.in);

    private List<Person> personList = new ArrayList<>();

    Menu() {
        start();
    }

    public void printMenu() {
        final String[] MENU_TEXT = {"1. add         lägga till en person\n" +
                "2. print       skriva ut listan med personer på skärmen\n" +
                "3. search      söka en person i listan\n" +
                "4. remove      ta bort en person från listan\n" +
                "5. sortN       sortera på namn\n" +
                "6. sortSig     sortera på signatur\n" +
                "7. sortH       sortera på längd\n" +
                "8. shuffle     slumpa ordningen\n" +
                "9. save        spara listan i en textfil.\n" +
                "10. read       läsa listan från en textfil.\n" +
                "0. quit, q     avsluta"};
        final String PROMPT = "Input>";
        for (String option : MENU_TEXT) {
            System.out.println(option);
        }
        PersonListSize();
        System.out.print(PROMPT);
    }

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
                case "1", ADD -> personList.add(makePerson());
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
                case "0", QUIT, Q -> run = stop();
                default -> System.out.println("Invalid option try again");
            }
        } while (run);
    }

    private boolean stop() {
        System.out.println("Stopping");
        return false;
    }

    private void PersonListSize() {
        System.out.println("Number of persons in current list: " + personList.size());
    }

    public Person makePerson() {
        System.out.print("Forename: ");
        String forename = keyboardIn.nextLine();
        System.out.print("Surname: ");
        String surname = keyboardIn.nextLine();

        System.out.print("Height in cm: ");
        int height = Integer.parseInt(keyboardIn.nextLine());

        System.out.print("Postal address: ");
        String postalAddress = keyboardIn.nextLine();
        System.out.print("zip code: ");
        String zipCode = keyboardIn.nextLine();
        System.out.print("Post office: ");
        String postOffice = keyboardIn.nextLine();

        String signature = makeSignature(forename, surname);

        return new Person(forename, surname, height, signature, new Address(postalAddress, zipCode, postOffice));
    }

    public Person makePerson(String[] personString){
        return new Person(personString[0], personString[1], Integer.parseInt(personString[3]), personString[2], new Address(personString[4], personString[5], personString[6]));
    }

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
        String temp;
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

    private int countOccurrencesOfID(String s) {
        int counter = 0;
        for (Person person : personList) {
            if (person.getSignature().contains(s)) {
                counter++;
            }
        }
        return counter;
    }

    public void add() {
        personList.add(makePerson());
    }

    public void print() {
        PersonListModifier.printPersons(personList);
    }

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

    public void sort(Comparator<Person> comparator) {
        PersonListModifier.sortPersons(personList, comparator);
    }

    public void shuffle() {
        PersonListModifier.shuffle(personList);
    }

    private void saveListToFile() {
        PersonListReadWrite.writeToFile(personList, SAVE_FILE);
    }

    private void readFromFile() {
        List<String> tempList = PersonListReadWrite.readFromFile(SAVE_FILE);
        personList.clear();
        for (String line : tempList) {
            personList.add(makePerson(line.split("\\|")));
        }
    }
}
