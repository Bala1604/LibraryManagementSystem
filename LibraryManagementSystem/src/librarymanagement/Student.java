package librarymanagement;

public class Student {

    private String studentId;
    private String studentName;

    // Constructor
    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    // Getter for student ID
    public String getStudentId() {
        return studentId;
    }

    // Getter for student name
    public String getStudentName() {
        return studentName;
    }

    // Display student details
    public void displayStudent() {
        System.out.println("Student ID  : " + studentId);
        System.out.println("Student Name: " + studentName);
    }
} 	