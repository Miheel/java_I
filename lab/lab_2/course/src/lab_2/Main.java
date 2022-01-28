package lab_2;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Course course1 = new Course();
        Course course2 = new Course();

        String courseName;
        String courseCode;
        String coursePoints;
        String courseDescription;


        course1.setCourseName("Java 1");
        course1.setCourseCode("DT196G");
        course1.setCoursePoints("7,5 hp");
        course1.setCourseDescription("Att lära dig olika sätt att läsa data från tangentbordet samt skriva en enkel klass och skapa objekt av denna klass.");

        System.out.println(course1);


        courseName = JOptionPane.showInputDialog("course name");
        courseCode = JOptionPane.showInputDialog("course code");
        coursePoints = JOptionPane.showInputDialog("course points");
        courseDescription = JOptionPane.showInputDialog("course cescription");

        course2.setCourseName(courseName);
        course2.setCourseCode(courseCode);
        course2.setCoursePoints(coursePoints);
        course2.setCourseDescription(courseDescription);

        System.out.println(course2);
    }
}
