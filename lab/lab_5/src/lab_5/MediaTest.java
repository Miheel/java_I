package lab_5;

import java.util.Scanner;

public class MediaTest {
    private static Scanner scanner =  new Scanner(System.in);

    public static void main(String[] args) {

        Book book1 = new Book();
        book1.setAuthor("Douglas Adams");
        book1.setTitle("The Hitchhiker's Guide to the Galaxy");
        book1.setLength(208);
        book1.setPublisher(new Publisher("Pan Books", "555-555-555"));
        book1.print();

        Book book2 = new Book("Alison Croggon", "The Gift", 480, new Publisher("Pengion books", "0000-1234-67"));
        System.out.println("Book:\n" +
                "\tAuthor: " + book2.getAuthor() + '\n' +
                "\tTitle: " + book2.getTitle() + '\n' +
                "\tLength: " + book2.getLength() + '\n' +
                "\tLengthAsString: " + book2.getLengthAsString() + '\n' +
                "\tPublisher: " + book2.getPublisher() + '\n');
        System.out.println(book2);

        pressEnter();

        CD cd1 = new CD();
        cd1.setArtist("Robert Wells");
        cd1.setTitle("Rhapsody in Rock");
        cd1.setLength(8001);
        cd1.setPublisher("Arthur Music", "010-123 45 67");
        cd1.print();

        CD cd2 = new CD("BuzzG ", "Symphony", 2407, new Publisher("MIYA Records", "02-1564-1465"));
        System.out.println("CD:\n" +
                "\tAuthor: " + cd2.getArtist() + '\n' +
                "\tTitle: " + cd2.getTitle() + '\n' +
                "\tLength: " + cd2.getLengthAsString() + '\n' +
                "\tPublisher: " + cd2.getPublisher() + '\n');
        System.out.println(cd2);

        pressEnter();

        DVD dvd1 = new DVD();
        dvd1.setTitle("Bioncie: Mask of Light");
        dvd1.setLength(4200);
        dvd1.setAgeLimit(7);
        dvd1.setPublisher("Miramax", "666-000-9999");
        dvd1.print();

        DVD dvd2 = new DVD("The Nightmare Before Chistmas ", 4380, 11, new Publisher("Buena Vista", "555-456-3548"));
        System.out.println("DVD:\n" +
                "\tTitle: " + dvd2.getTitle() + '\n' +
                "\tLength: " + dvd2.getLengthAsString() + '\n' +
                "\tAge limit: " + dvd2.getAgeLimit() + '\n' +
                "\tPublisher: " + dvd2.getPublisher() + '\n');
        System.out.println(dvd2);
    }

    public static void pressEnter(){
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
}
