package lab_5;

public class DVD extends Media {

    private int ageLimit;

    public DVD() {
        super();
        this.ageLimit = 0;
    }

    public DVD(String title, int length, int ageLimit, Publisher publisher) {
        super(title, length, publisher);
        if (ageLimit < 0) {
            this.ageLimit = 0;
        } else {
            this.ageLimit = ageLimit;
        }
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        if (ageLimit < 0) {
            this.ageLimit = 0;
        } else {
            this.ageLimit = ageLimit;
        }
    }

    public String getLengthAsString() {
        int hour = getLength() / 3600;
        int secRemain = getLength() % 3600;
        int min = secRemain / 60;
        int sec = secRemain % 60;
        return String.format("%02dh %02dm %02ds", hour, min, sec);
    }

    @Override
    public void print() {
        System.out.println("DVD:\n" +
                "\tageLimit: " + ageLimit + '\n' +
                "\tlength: " + getLengthAsString());
        super.print();
    }

    @Override
    public String toString() {
        return "DVD{" +
                "ageLimit=" + ageLimit +
                '}';
    }
}
