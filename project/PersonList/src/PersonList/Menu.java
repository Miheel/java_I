package PersonList;

import java.util.*;

public class Menu {

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
                case "1", ADD:
                    addPerson();
                    break;
                case "2", PRINT:
                    print();
                    break;
                case "3", SEARCH:
                    search();
                    break;
                case "4", REMOVE:
                    remove();
                    break;
                case "5", SORT_NAME:
                    //sortByName
                    sort(new ComparePersonName());
                    break;
                case "6", SORT_SIGNATURE:
                    //sortBySignature
                    sort(new ComparePersonSignature());
                    break;
                case "7", SORT_HEIGHT:
                    //sortByHeight
                    sort(new ComparePersonHeight());
                    break;
                case "8", SHUFFLE:
                    shuffle();
                    break;
                case "9", SAVE:
                    //saveToFile();
                    break;
                case "10", READ:
                    //personList = readFromFile();
                    break;
                case "0", QUIT, Q:
                    run = stop();

                    break;
                default:
                    System.out.println("Invalid option try again");
            }
        } while (run == true);
    }

    private boolean stop() {
        System.out.println("Stopping");
        return false;
    }

    private void PersonListSize() {
        System.out.println("Number of persons in current list: " + personList.size());
    }

    public void addPerson() {

        String signature = makeSignature("micke", "leuf");
        Person tempP = new Person("micke", "leuf", 174, signature, new Address("frideborgsgatan", "87160", "härnösand"));
        personList.add(tempP);
        signature = makeSignature("micke", "leuf");
        Person tempP4 = new Person("micke", "leuf", 145, signature, new Address("frideborgsgatan", "87160", "härnösand"));
        personList.add(tempP4);

        signature = makeSignature("linda", "leuf");
        Person tempP1 = new Person("linda", "leuf", 154, signature, new Address("frideborgsgatan", "87160", "härnösand"));
        signature = makeSignature("johan Alexander lugvig", "norgren");
        Person tempP2 = new Person("johan Alexander lugvig", "norgren", 175, signature, new Address("frideborgsgatan", "87160", "härnösand"));
        signature = makeSignature("martin", "yxberg");
        Person tempP3 = new Person("martin", "yxberg", 180, signature, new Address("frideborgsgatan", "87160", "härnösand"));

        signature = makeSignature("carl", "ek");
        Person tempP5 = new Person("micke", "leuf", 174, signature, new Address("frideborgsgatan", "87160", "härnösand"));
        signature = makeSignature("bo", "ek");
        Person tempP6 = new Person("micke", "leuf", 174, signature, new Address("frideborgsgatan", "87160", "härnösand"));
        signature = makeSignature("w", "e");
        Person tempP7 = new Person("w", "e", 174, signature, new Address("frideborgsgatan", "87160", "härnösand"));


        personList.add(tempP1);
        personList.add(tempP2);
        personList.add(tempP3);

        personList.add(tempP5);
        personList.add(tempP6);
        personList.add(tempP7);
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

        Person tempP = new Person(forename, surname, height, signature, new Address(postalAddress, zipCode, postOffice));
        return tempP;
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
            IDPart1 = String.format("%-3s",IDPart1).replace(' ', 'x');

        } else {
            IDPart1 = forename.substring(0, 3);
        }
        String temp;
        if (surname.length() <= 3) {
            IDPart2 = surname;
            //IDPart2 += surname.length() == 2 ? "x" : "xx";
            IDPart2 = String.format("%-3s",IDPart2).replace(' ', 'x');
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

    public void sort(Comparator comparator) {
        PersonListModifier.sortPersons(personList, comparator);
    }

    public void shuffle() {
        PersonListModifier.shuffle(personList);
    }

}
