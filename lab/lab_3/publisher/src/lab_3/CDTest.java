package lab_3;

import javax.swing.*;

/**
 * Test class for CD objects
 * testing the methods and contructors of objects of CD with and without keyboard inputs
 * @author Mikael Leuf
 * @version 1.0
 */
public class CDTest {

    public static void main(String[] args) {
        System.out.println("Testing CD class' parametrized constructor, toString and print methods");
        CD mcrCD = new CD("The Black Parade", "My Chemical Romance", 51, new Publisher("Reprise Records", "000-123 45 67"));
        System.out.println(mcrCD);
        mcrCD.print();


        System.out.println("Testing CD class' no-arg constructor(default constructor) and set methods");
        CD greenDayCD = new CD();
        greenDayCD.setTitle("Boulevard of Broken Dreams");
        greenDayCD.setArtist("Green Day");
        greenDayCD.setLength(4);
        greenDayCD.setPublisher("Reprise Records", "000-123 45 67");
        System.out.println(greenDayCD);
        greenDayCD.print();


        System.out.println("Testing Publisher class' get methods");
        String title = JOptionPane.showInputDialog("Title of CD");
        String artist = JOptionPane.showInputDialog("Artist of CD");

        int length = 0;
        boolean validCdLength = false;
        do {
            try {
                length = Integer.parseInt(JOptionPane.showInputDialog("Length of CD as whole number"));
                validCdLength = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "expected an integer but got\n" + e.getMessage(), "Error message", JOptionPane.ERROR_MESSAGE);
                System.out.println("expected an integer but got: " + e.getMessage());
            }
        } while (!validCdLength);

        String publisherName = JOptionPane.showInputDialog("CD publisher name");
        String publisherPhone = JOptionPane.showInputDialog("CD publisher phone");
        CD cd = new CD(title, artist, length, new Publisher(publisherName, publisherPhone));

        System.out.println("Artist: " + cd.getArtist() + '\n' +
                "Title: " + cd.getTitle()  + '\n' +
                "Length: " + cd.getLength()  + '\n' +
                "publisher: " + cd.getPublisher().getName()
        );
    }
}
