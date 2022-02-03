package lab_3;

/**
 * CD class represents a CD
 * @author Mikael Leuf
 * @version 1.0
 */
public class CD {

    private String title;
    private String artist;
    private int length;
    private Publisher publisher;

    /**
     * Creates an empty CD object
     */
    public CD() {
        this.title = "Not set";
        this.artist = "Not set";
        this.length = 0;
        this.publisher = new Publisher();
    }

    /**
     * Constructs anew CD holding information about a particular cd
     * @param title Tittle of the cd
     * @param artist artist preforming on the cd
     * @param length play length of the cd in seconds
     * @param publisher publisher of the cd
     */
    public CD(String title, String artist, int length, Publisher publisher) {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setPublisher(String name, String phone) {
        this.publisher.setName(name);
        this.publisher.setPhone(phone);
    }

    /**
     * Prints out information about the publisher to the console
     */
    public void print(){
        System.out.println("CD:\n" +
                "\ttitle='" + title + '\n' +
                "\tartist='" + artist + '\n' +
                "\tlength=" + length + '\n' +
                "\tpublisher:\n" +
                "\t\tname='" + publisher.getName() + '\n'
        );
    }

    /**
     * returns a String representation of the Publisher object
     * @return a String representation of the Publisher object
     */
    @Override
    public String toString() {
        return "CD{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", length=" + length + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
