package librarymanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Check Book Availability");
            System.out.println("7. Calculate Fine");
            System.out.println("8. Due Date Reminder");
            System.out.println("9. Generate Report");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n===== ADD BOOK =====");

                    System.out.print("Enter Book ID: ");
                    String bookId = sc.next();

                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(
                            bookId,
                            title,
                            author
                    );

                    library.addBook(book);

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.println("\n===== SEARCH BOOK =====");

                    System.out.print("Enter Book ID to search: ");

                    String searchId = sc.next();

                    library.searchBook(searchId);

                    break;

                case 4:

                    System.out.println("\n===== ISSUE BOOK =====");

                    System.out.print("Enter Book ID: ");
                    String issueBookId = sc.next();

                    System.out.print("Enter Student ID: ");
                    String studentId = sc.next();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();

                    library.issueBook(
                            issueBookId,
                            studentId,
                            studentName
                    );

                    break;

                case 5:

                    System.out.println("\n===== RETURN BOOK =====");

                    System.out.print("Enter Book ID: ");

                    String returnBookId = sc.next();

                    library.returnBook(returnBookId);

                    break;

                case 6:

                    System.out.println(
                            "\n===== CHECK BOOK AVAILABILITY ====="
                    );

                    System.out.print("Enter Book ID: ");

                    String availabilityBookId = sc.next();

                    library.checkAvailability(
                            availabilityBookId
                    );

                    break;

                case 7:

                    System.out.println("\n===== FINE CALCULATOR =====");

                    System.out.print("Enter late days: ");

                    long lateDays = sc.nextLong();

                    library.calculateFine(lateDays);

                    break;

                case 8:

                    System.out.println(
                            "\n===== DUE DATE REMINDER ====="
                    );

                    System.out.print("Enter Book ID: ");

                    String reminderBookId = sc.next();

                    library.dueDateReminder(
                            reminderBookId
                    );

                    break;

                case 9:

                    library.generateReport();

                    break;

                case 0:

                    System.out.println(
                            "\nThank you for using Library Management System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice! Please try again."
                    );
            }

        } while (choice != 0);

        sc.close();
    }
}