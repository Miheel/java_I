package lab_3;

/**
 * Test class for Publisher objects
 * testing the methods and contructors of objects of Publisher
 * @author Mikael Leuf
 * @version 1.0
 */
public class PublisherTest1 {

    public static void main(String[] args) {

        System.out.println("Testing Publisher class' parametrized constructor, toString and print methods");
        Publisher p1 = new Publisher("publisher ab", "070-000 00 01");
        System.out.println(p1);
        p1.print();

        System.out.println("Testing Publisher class' no-arg constructor(default constructor) and set methods");
        Publisher p2 = new Publisher();
        System.out.println(p2);
        p2.setName("publisher and co");
        p2.setPhone("070-000 00 02");
        p2.print();

        System.out.println("Testing Publisher class' get methods");
        Publisher p3 = new Publisher("publisher inc", "070-000 00 03");
        System.out.println(p3);
        String name = p3.getName();
        String phone = p3.getPhone();
        System.out.println("publisher name " + name + "\nPublisher phone " + phone);
    }

}
