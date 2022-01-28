package lab_2;

public class Course {

    private String courseName;
    private String courseCode;
    private String CoursePoints;
    private String courseDescription;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCoursePoints(String coursePints) {
        CoursePoints = coursePints;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        return "Course\n" +
                "\tcourseName: " + courseName + '\n' +
                "\tcourseCode: " + courseCode + '\n' +
                "\tCoursePints: " + CoursePoints + '\n' +
                "\tcourseDescription: " + courseDescription + '\n';
    }
}

