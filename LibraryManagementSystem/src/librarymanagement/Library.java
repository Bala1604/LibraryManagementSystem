package librarymanagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    private Map<String, Book> issuedBooks = new HashMap<>();

    private Map<String, IssueRecord> issueRecords = new HashMap<>();

    private FineCalculator fineCalculator = new FineCalculator();

    // ==========================================
    // ADD BOOK
    // ==========================================

    public void addBook(Book book) {

        books.add(book);

        System.out.println("Book added successfully!");
    }

    // ==========================================
    // DISPLAY ALL BOOKS
    // ==========================================

    public void displayBooks() {

        System.out.println("\n===== ALL BOOKS =====");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {

            book.displayBookDetails();
        }
    }

    // ==========================================
    // SEARCH BOOK
    // ==========================================

    public void searchBook(String bookId) {

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {

                System.out.println("\n===== BOOK FOUND =====");

                book.displayBookDetails();

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // ==========================================
    // ISSUE BOOK
    // ==========================================

    public void issueBook(String bookId,
                           String studentId,
                           String studentName) {

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {

                if (!book.isAvailable()) {

                    System.out.println("Book is already issued!");
                    return;
                }

                // Mark book as issued
                book.setAvailable(false);

                // Store issued book
                issuedBooks.put(bookId, book);

                // Create issue record
                IssueRecord record = new IssueRecord(
                        book.getBookId(),
                        book.getTitle(),
                        studentId,
                        studentName
                );

                // Store issue record
                issueRecords.put(bookId, record);

                System.out.println("\n===== ISSUE BOOK =====");

                System.out.println("Book issued successfully!");

                record.displayIssueDetails();

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // ==========================================
    // RETURN BOOK
    // ==========================================

    public void returnBook(String bookId) {

        IssueRecord record = issueRecords.get(bookId);

        if (record == null) {

            System.out.println("This book is not currently issued!");
            return;
        }

        LocalDate returnDate = LocalDate.now();

        record.setReturnDate(returnDate);

        // Calculate late days
        long lateDays = ChronoUnit.DAYS.between(
                record.getDueDate(),
                returnDate
        );

        if (lateDays < 0) {
            lateDays = 0;
        }

        // Calculate fine
        double fine = fineCalculator.calculateFine(lateDays);

        System.out.println("\n===== RETURN DETAILS =====");

        System.out.println("Book ID      : " + record.getBookId());
        System.out.println("Book Title   : " + record.getBookTitle());
        System.out.println("Student Name : " + record.getStudentName());
        System.out.println("Issue Date   : " + record.getIssueDate());
        System.out.println("Due Date     : " + record.getDueDate());
        System.out.println("Return Date  : " + record.getReturnDate());
        System.out.println("Late Days    : " + lateDays);
        System.out.println("Fine         : ₹" + fine);

        // Make book available
        Book book = issuedBooks.get(bookId);

        if (book != null) {
            book.setAvailable(true);
        }

        // Remove issue information
        issuedBooks.remove(bookId);
        issueRecords.remove(bookId);

        System.out.println("\nBook returned successfully!");
    }

    // ==========================================
    // CHECK AVAILABILITY
    // ==========================================

    public void checkAvailability(String bookId) {

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {

                if (book.isAvailable()) {
                    System.out.println("Book is available.");
                } else {
                    System.out.println("Book is currently issued.");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // ==========================================
    // CALCULATE FINE
    // ==========================================

    public void calculateFine(long lateDays) {

        fineCalculator.displayFine(lateDays);
    }

    // ==========================================
    // DUE DATE REMINDER
    // ==========================================

    public void dueDateReminder(String bookId) {

        IssueRecord record = issueRecords.get(bookId);

        if (record == null) {

            System.out.println("This book is not currently issued!");
            return;
        }

        LocalDate today = LocalDate.now();

        LocalDate dueDate = record.getDueDate();

        long daysRemaining = ChronoUnit.DAYS.between(
                today,
                dueDate
        );

        System.out.println("\n===== DUE DATE REMINDER =====");

        System.out.println("Book ID      : " + record.getBookId());
        System.out.println("Book Title   : " + record.getBookTitle());
        System.out.println("Student Name : " + record.getStudentName());
        System.out.println("Due Date     : " + dueDate);

        if (daysRemaining > 0) {

            System.out.println("Days Remaining : " + daysRemaining);

            if (daysRemaining <= 3) {

                System.out.println(
                        "Reminder: Book is due in "
                        + daysRemaining
                        + " days!"
                );

            } else {

                System.out.println("Book is not due yet.");
            }

        } else if (daysRemaining == 0) {

            System.out.println("Book is due today!");

        } else {

            long overdueDays = Math.abs(daysRemaining);

            System.out.println("Days Overdue : " + overdueDays);
            System.out.println("Reminder: Book is overdue!");
        }
    }

    // ==========================================
    // GENERATE REPORT
    // ==========================================

    public void generateReport() {

        int totalBooks = books.size();

        int availableBooks = 0;
        int issuedBooksCount = 0;

        for (Book book : books) {

            if (book.isAvailable()) {
                availableBooks++;
            } else {
                issuedBooksCount++;
            }
        }

        System.out.println("\n===== LIBRARY REPORT =====");

        System.out.println("Total Books     : " + totalBooks);
        System.out.println("Available Books : " + availableBooks);
        System.out.println("Issued Books    : " + issuedBooksCount);
    }
}