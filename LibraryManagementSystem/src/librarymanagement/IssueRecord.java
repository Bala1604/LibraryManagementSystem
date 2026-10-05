package librarymanagement;

import java.time.LocalDate;

public class IssueRecord {

    private String bookId;
    private String bookTitle;
    private String studentId;
    private String studentName;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    // Constructor
    public IssueRecord(String bookId, String bookTitle,
                       String studentId, String studentName) {

        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.studentId = studentId;
        this.studentName = studentName;

        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(14);
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void displayIssueDetails() {

        System.out.println("\n===== ISSUE DETAILS =====");

        System.out.println("Book ID      : " + bookId);
        System.out.println("Book Title   : " + bookTitle);
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
        System.out.println("Issue Date   : " + issueDate);
        System.out.println("Due Date     : " + dueDate);
    }
}