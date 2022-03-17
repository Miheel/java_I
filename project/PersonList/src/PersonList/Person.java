package PersonList;

import java.util.Comparator;

/**
 * class representing a Person object
 */
public class Person {
    private String forename;
    private String surname;
    private int height;
    private String signature;
    private Address address;

    public Person(String forename, String surname, int height, String signature, Address address) {
        this.forename = forename;
        this.surname = surname;
        this.height = height;
        this.signature = signature;
        this.address = address;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHeightCM() {
        return height;
    }

    public double getHeightM() {
        return height / 100.0;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress(String postalAddress, String zipCode, String postOffice) {
        this.address = new Address(postalAddress, zipCode, postOffice);
    }

    public void printPerson() {
        System.out.printf("%-10s %-20.20s %.2f\n", getSignature(), getForename() + " " + getSurname(), getHeightM());
    }

    @Override
    public String toString() {
        return "Person{" +
                "forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", address=" + address +
                '}';
    }

    public String toSerial() {
        return forename + '|' +
                surname + '|' +
                signature + '|' +
                height + '|' +
                address.getPostalAddress() + '|' +
                address.getZipCode() + '|' +
                address.getPostOffice();
    }

}

class ComparePersonName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getSurname().equals(p2.getSurname())) {
            return p1.getForename().compareTo(p2.getForename());
        }
        return p1.getSurname().compareTo(p2.getSurname());
    }
}

class ComparePersonSignature implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getSignature().compareTo(p2.getSignature());
    }
}

class ComparePersonHeight implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getHeightCM() - p2.getHeightCM();
    }
}
