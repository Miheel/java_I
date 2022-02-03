package lab_3;

import javax.swing.*;

/**
 * Test class for Publisher objects
 * testing the methods and contructors of objects of Publisher with keyboard input
 * @author Mikael Leuf
 * @version 1.0
 */
public class PublisherTest2 {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        publisher.setName(JOptionPane.showInputDialog("type a name for the publisher"));
        publisher.setPhone(JOptionPane.showInputDialog("type a phone nr for the publisher"));

        System.out.println(publisher);
        publisher.print();
        String name = publisher.getName();
        String phone = publisher.getPhone();
        System.out.println("publisher name: " + name + " phone: " + phone);
    }
}
