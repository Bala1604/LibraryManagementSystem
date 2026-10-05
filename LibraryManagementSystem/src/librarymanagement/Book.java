package librarymanagement;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private boolean available;

    // Constructor
    public Book(String bookId, String title, String author) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Display book details
    public void displayBookDetails() {

        System.out.println("----------------------");
        System.out.println("Book ID     : " + bookId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);

        if (available) {
            System.out.println("Availability: Available");
        } else {
            System.out.println("Availability: Issued");
        }
    }
}