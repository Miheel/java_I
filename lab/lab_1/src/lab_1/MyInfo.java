package lab_1;

public class MyInfo {

    public static String NAME = "Mikael Leuf";
    public static String TOWN = "Hörösand";
    public static String COURSE_CHOICE = "Java 1 is part of the computer science program at miun";

    public static void printPersonInfo() {
        System.out.println(textBox("Name", NAME));

        System.out.println(textBox("HomeTown", TOWN));

        System.out.println(textBox("Why this course", COURSE_CHOICE));
    }

    public static String textBox(String title, String attribute){
        String corner = "+", side = "|", spacing = " ", topBot = "-";
        int len = Math.max(title.length(), attribute.length()) + 2;

        String ceiling = corner + topBot.repeat(len) + corner + '\n';
        String contentL = side + spacing + title;
        String contentR = spacing.repeat(len - contentL.length() + 1) + side;
        String floor = '\n' + ceiling;
        String titleBox = ceiling + contentL + contentR + floor;

        contentL = side + spacing + attribute;
        contentR = spacing.repeat(len - contentL.length() + 1) + side;

        String attributeBox = contentL + contentR + floor;

        return titleBox + attributeBox;
    }
}
