package lab_5;

public class Book extends Media{
    private String author;

    public Book(){
        super();
        this.author = "Not set";
    }
    public Book(String author, String title, int length, Publisher publisher) {
        super(title, length, publisher);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLengthAsString() {
        return String.format("%d %s", getLength(), getLength() > 1 ? "pages" : "page");
    }

    @Override
    public void print() {
        System.out.println("Book:\n" +
                "\tauthor: " + author + '\n' +
                "\tlength: " + getLengthAsString());
        super.print();
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }
}
