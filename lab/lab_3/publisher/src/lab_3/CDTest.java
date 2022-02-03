package lab_3;

import javax.swing.*;
import java.util.Scanner;

public class CDTest {

    public static void main(String[] args){
        CD mcrCD = new CD("The Black Parade", "My Chemical Romance", 51, new Publisher("Reprise Records", "000-123 45 67"));
        System.out.println(mcrCD);
        mcrCD.print();


        CD greenDayCD = new CD();
        greenDayCD.setTitle("Boulevard of Broken Dreams");
        greenDayCD.setArtist("Green Day");
        greenDayCD.setLength(4);
        greenDayCD.setPublisher("Reprise Records", "000-123 45 67");
        System.out.println(greenDayCD);
        greenDayCD.print();



        CD cd = new CD();
        String title = JOptionPane.showInputDialog("Title of CD");
        cd.setTitle(title);

        String artist = JOptionPane.showInputDialog("Artist of CD");
        cd.setArtist(artist);

        int length = 0;
        boolean validCdLength = false;
        do {
            try {
                length = Integer.parseInt(JOptionPane.showInputDialog("Length of CD as whole number"));
                validCdLength = true;
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "expected an integer but got\n" + e.getMessage(), "Error message", JOptionPane.ERROR_MESSAGE);
                System.out.println("expected an integer but got: " + e.getMessage());
            }
        }while (!validCdLength);

        cd.setLength(length);

        String publisherName = JOptionPane.showInputDialog("CD publisher name");
        String publisherPhone = JOptionPane.showInputDialog("CD publisher phone");
        cd.setPublisher(new Publisher(publisherName, publisherPhone));

        System.out.println(cd);
        cd.print();
    }
}
