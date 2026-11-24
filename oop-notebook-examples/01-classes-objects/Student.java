// Program 1: Classes, Objects, Attributes and Methods
// File: Student.java

public class Student {
    // Attributes (fields)
    String name;
    int mark;
    String course;

    // Method: assign values to the object
    void setDetails(String studentName, int studentMark, String studentCourse) {
        name = studentName;
        mark = studentMark;
        course = studentCourse;
    }

    // Method: display student information
    void displayInfo() {
        System.out.println("Name: " + name + " | Mark: " + mark + " | Course: " + course);
    }

    // Method: check if student passed
    void checkResult() {
        if (mark >= 50) {
            System.out.println(name + " has PASSED.");
        } else {
            System.out.println(name + " has FAILED.");
        }
    }

    public static void main(String[] args) {
        // Creating objects from the Student class
        Student s1 = new Student();
        Student s2 = new Student();

        s1.setDetails("Lerato", 82, "CSSE");
        s2.setDetails("Prince", 45, "CSSE");

        System.out.println("--- Student Records ---");
        s1.displayInfo();
        s1.checkResult();

        s2.displayInfo();
        s2.checkResult();
    }
}
