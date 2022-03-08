package lab_5;

public class Media {
    protected String title;
    protected int length;
    protected Publisher publisher;

    public Media() {
        this.title = "Not set";
        this.length = 0;
        this.publisher = new Publisher();
    }

    public Media(String title, int length, Publisher publisher) {
        this.title = title;
        if (length < 0) {
            this.length = 0;
        } else {
            this.length = length;
        }
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 0) {
            this.length = 0;
        } else {
            this.length = length;
        }
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

    public void print() {
        System.out.println("\ttitle: " + title + '\n' +
                "\tlength: " + length + '\n' +
                "\tpublisher:");
        publisher.print();
    }

    @Override
    public String toString() {
        return "Media{" +
                "title='" + title + '\'' +
                ", length=" + length +
                ", publisher=" + publisher +
                '}';
    }
}
