package lab_5;

public class Publisher {
    private String name;
    private String phone;
    private static int nrOfPublisher = 0;

    /**
     * Creates an empty publisher object
     */
    public Publisher() {
        this.setName("Not set");
        this.setPhone("Not set");
        nrOfPublisher++;
    }

    /**
     * Creates a Publisher object with a name and phone number arguments
     *
     * @param name  name of the publisher
     * @param phone phone nr of the publisher
     */
    public Publisher(String name, String phone) {
        this.setName(name);
        this.setPhone(phone);
        nrOfPublisher++;
    }

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
    public void print() {
        System.out.println("\t\tname=" + getName() + '\n' +
                "\t\tphone=" + getPhone());
    }

    /**
     * returns a String representation of the Publisher object
     *
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
