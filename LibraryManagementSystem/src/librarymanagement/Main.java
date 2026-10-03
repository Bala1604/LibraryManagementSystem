package librarymanagement;

public class Main {

    public static void main(String[] args) {

        // Create Library
        Library library = new Library();

        // Create Books
        Book book1 = new Book(
                "B101",
                "Java Programming",
                "Herbert Schildt"
        );

        Book book2 = new Book(
                "B102",
                "SQL Basics",
                "James"
        );

        Book book3 = new Book(
                "B103",
                "Spring Boot",
                "Craig Walls"
        );

        // Add books
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Create Student
        Student student1 =
                new Student("S101", "Balamurugan");


        library.displayAllBooks();

        // Issue book
        System.out.println("\n===== ISSUE BOOK =====");

        library.issueBook("B101", student1);

        // Check availability
        System.out.println("\n===== CHECK AVAILABILITY =====");

        library.checkAvailability("B101");

        // Search book
        System.out.println("\n===== SEARCH BOOK =====");

        library.searchBook("B101");
        
     // Return book
        System.out.println("\n===== RETURN BOOK =====");

        library.returnBook("B101");

        // Check availability again
        System.out.println("\n===== AVAILABILITY AFTER RETURN =====");

        library.checkAvailability("B101");
        
        
        Librarian librarian =new Librarian("Arun");
        
        System.out.println("\n===== LIBRARIAN APPROVAL =====");

        Book requestedBook =library.findBook("B101");

        boolean approved =librarian.approveBookIssue(requestedBook);

        if (approved) {

            library.issueBook("B101",student1 );
        }
        
        System.out.println("\n===== FINE COLLECTION =====");

        librarian.collectFine(15);
        
        System.out.println("\n===== DUE DATE REMINDER =====");

        library.dueDateReminder();
        
        
        System.out.println("\n===== GENERATE REPORT =====");

        library.generateReport();
        
        Librarian librarian1 = new Librarian("Arun");

        System.out.println("\n===== LIBRARIAN REPORT =====");

        librarian1.generateReport(library);

        System.out.println("\n===== LIBRARIAN DUE REMINDER =====");

        librarian1.showDueDateReminder(library);
    }
    
   
   
    
}