package lab_3;

/**
 * Publisher class representing a publishing firm
 * @author Mikael Leuf
 * @version 1.0
 */
public class Publisher {
    private String name;
    private String phone;
    private static int nrOfPublisher = 0;

    /**
     * Creates an empty publisher object
     */
    public Publisher() {
        this.name = "Not set";
        this.phone = "Not set";
        nrOfPublisher++;
    }

    /**
     * Creates a Publisher object with a name and phone number arguments
     * @param name name of the publisher
     * @param phone phone nr of the publisher
     */
    public Publisher(String name, String phone) {
        this.name = name;
        this.phone = phone;
        nrOfPublisher++;
    }

    /**
     * Returns the number of publisher objects created
     * @return the number of publisher objects created
     */
    public static int getNrOfPublisher() {
        return nrOfPublisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Prints out information about the publisher to the console
     */
    public void print(){
        System.out.println("Publisher:\n" +
                "\tname='" + getName() + '\n' +
                "\tphone='" + getPhone() + '\n');
    }

    /**
     * returns a String representation of the Publisher object
     * @return a String representation of the Publisher object
     */
    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", nrOfPublisher='" + getNrOfPublisher() + '\'' +
                '}';
    }
}
