package librarymanagement;

import java.time.LocalDate;

public class IssueRecord {

    private Book book;
    private Student student;
    private LocalDate issueDate;
    private LocalDate dueDate;

    // Constructor
    public IssueRecord(Book book, Student student) {

        this.book = book;
        this.student = student;

        // Current date
        this.issueDate = LocalDate.now();

        // Due date after 14 days
        this.dueDate = issueDate.plusDays(14);
    }

    // Getters
    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // Display issue details
    public void displayIssueDetails() {

        System.out.println("Book ID     : " + book.getBookId());
        System.out.println("Book Title  : " + book.getTitle());
        System.out.println("Student ID  : " + student.getStudentId());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Issue Date  : " + issueDate);
        System.out.println("Due Date    : " + dueDate);
    }
}