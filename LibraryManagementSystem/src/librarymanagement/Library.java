package librarymanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {

    // Store all books
    private ArrayList<Book> books;

    // Store issued books
    private Map<String, IssueRecord> issuedBooks;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        issuedBooks = new HashMap<>();
    }

    // =========================
    // ADD BOOK
    // =========================

    public void addBook(Book book) {

        books.add(book);

        System.out.println("Book added successfully!");
    }

    // =========================
    // DISPLAY ALL BOOKS
    // =========================

    public void displayAllBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("\n===== ALL BOOKS =====");

        for (Book book : books) {

            book.displayBook();

            System.out.println("----------------------");
        }
    }

    // =========================
    // SEARCH BOOK
    // =========================

    public void searchBook(String bookId) {

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {

                System.out.println("\nBook found!");

                book.displayBook();

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // =========================
    // CHECK AVAILABILITY
    // =========================

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

        System.out.println("Book not found.");
    }

    // =========================
    // ISSUE BOOK
    // =========================

    public void issueBook(String bookId, Student student) {

        for (Book book : books) {

            if (book.getBookId().equalsIgnoreCase(bookId)) {

                // Check availability
                if (!book.isAvailable()) {

                    System.out.println("Book is already issued.");

                    return;
                }

                // Create issue record
                IssueRecord record =
                        new IssueRecord(book, student);

                // Store in HashMap
                issuedBooks.put(book.getBookId(), record);

                // Mark book as unavailable
                book.setAvailable(false);

                System.out.println("Book issued successfully!");

                record.displayIssueDetails();

                return;
            }
        }

        System.out.println("Book not found.");
    }
    
 // =========================
 // RETURN BOOK
 // =========================

 public void returnBook(String bookId) {

     // Check whether book is issued
     IssueRecord record = issuedBooks.get(bookId);

     if (record == null) {
         System.out.println("This book is not currently issued.");
         return;
     }

     // Get return date
     java.time.LocalDate returnDate =
             java.time.LocalDate.now();

     // Calculate fine
     double fine = FineCalculator.calculateFine(
             record.getDueDate(),
             returnDate
     );

     long lateDays = FineCalculator.calculateLateDays(
             record.getDueDate(),
             returnDate
     );

     System.out.println("\n===== RETURN DETAILS =====");

     System.out.println("Book ID     : "
             + record.getBook().getBookId());

     System.out.println("Book Title  : "
             + record.getBook().getTitle());

     System.out.println("Student Name: "
             + record.getStudent().getStudentName());

     System.out.println("Issue Date  : "
             + record.getIssueDate());

     System.out.println("Due Date    : "
             + record.getDueDate());

     System.out.println("Return Date : "
             + returnDate);

     System.out.println("Late Days   : "
             + lateDays);

     System.out.println("Fine        : ₹"
             + fine);

     // Make book available
     record.getBook().setAvailable(true);

     // Remove from issued books
     issuedBooks.remove(bookId);

     System.out.println("Book returned successfully!");  
     
 }
 
//Find book by ID
public Book findBook(String bookId) {

  for (Book book : books) {

      if (book.getBookId().equalsIgnoreCase(bookId)) {
          return book;
      }
  }

  return null;
}


//=========================
//DUE DATE REMINDER
//=========================

public void dueDateReminder() {

 if (issuedBooks.isEmpty()) {

     System.out.println("No books are currently issued.");
     return;
 }

 java.time.LocalDate today = java.time.LocalDate.now();

 System.out.println("\n===== DUE DATE REMINDER =====");

 for (IssueRecord record : issuedBooks.values()) {

     java.time.LocalDate dueDate = record.getDueDate();

     System.out.println("\nBook       : "  + record.getBook().getTitle());

     System.out.println("Student    : "  + record.getStudent().getStudentName());

     System.out.println("Due Date   : " + dueDate);

     if (today.isAfter(dueDate)) {

         System.out.println("Status     : OVERDUE");

     } else if (today.isEqual(dueDate)) {

         System.out.println("Status     : DUE TODAY");

     } else {

         long remainingDays = java.time.temporal.ChronoUnit.DAYS.between(today,dueDate);

         System.out.println( "Status     : Due in " + remainingDays    + " days" );
     }
 }
}
//=========================
//GENERATE LIBRARY REPORT
//=========================

public void generateReport() {

 int totalBooks = books.size();
 int availableBooks = 0;
 int issuedBooksCount = issuedBooks.size();

 for (Book book : books) {

     if (book.isAvailable()) {
         availableBooks++;
     }
 }

 System.out.println("\n====================================");
 System.out.println("          LIBRARY REPORT");
 System.out.println("====================================");

 System.out.println("Total Books     : " + totalBooks);
 System.out.println("Available Books : " + availableBooks);
 System.out.println("Issued Books    : " + issuedBooksCount);

 System.out.println("====================================");
}
}

