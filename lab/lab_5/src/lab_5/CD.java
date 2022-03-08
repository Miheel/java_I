package lab_5;

/**
 * CD class represents a CD
 * @author Mikael Leuf
 * @version 1.0
 */
public class CD extends Media{

    private String artist;

    /**
     * Creates an empty CD object
     */
    public CD() {
        super();
        this.artist = "Not set";
    }

    /**
     * Constructs anew CD holding information about a particular cd
     * @param artist artist preforming on the cd
     * @param title Tittle of the cd
     * @param length play length of the cd in seconds
     * @param publisher publisher of the cd
     */
    public CD(String artist, String title, int length, Publisher publisher) {
        super(title, length, publisher);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLengthAsString() {
        int hour = getLength() / 3600;
        int secRemain = getLength() % 3600;
        int min = secRemain / 60;
        int sec = secRemain % 60;
        return String.format("%02dh %02dm %02ds", hour, min, sec);
    }

    /**
     * Prints out information about the publisher to the console
     */
    @Override
    public void print() {
        System.out.println("CD:\n" +
                "\tartist: " + artist + '\n' +
                "\tlength: " + this.getLengthAsString());
        super.print();
    }

    /**
     * returns a String representation of the Publisher object
     * @return a String representation of the Publisher object
     */
    @Override
    public String toString() {
        return "CD{" +
                "artist=" + artist +
                '}';
    }
}
