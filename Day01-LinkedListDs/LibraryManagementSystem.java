class BookNode {
    String title, author, genre, bookId;
    boolean isAvailable;
    BookNode next, prev;
    public BookNode(String title, String author, String genre, String bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
class Library {
    private BookNode head, tail;
    private int totalBooks;
    public Library() {
        head = tail = null;
        totalBooks = 0;
    }
    // Add a book at the beginning
    public void addAtBeginning(String title, String author, String genre, String bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        totalBooks++;
    }// Add book at end
    public void addAtEnd(String title, String author, String genre, String bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalBooks++;
    }  // Add a book at a specific position
    public void addAtPosition(int position, String title, String author, String genre, String bookId, boolean isAvailable) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) current = current.next;
        if (current == null || current == tail) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        totalBooks++;
    }
    // Remove a book by Book ID
    public void removeByBookId(String bookId) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId.equalsIgnoreCase(bookId)) {
                if (current == head) head = head.next;
                if (current == tail) tail = tail.prev;
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                System.out.println("Book removed: " + bookId);
                totalBooks--;
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found: " + bookId);
    }
    public void searchByTitleOrAuthor(String title, String author) {// Search book by Title/Author
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if ((title != null && current.title.equalsIgnoreCase(title)) || 
                (author != null && current.author.equalsIgnoreCase(author))) {
                displayBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No books found matching the criteria.");
    }
    // Update a book's Availability Status
    public void updateAvailability(String bookId, boolean newStatus) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId.equalsIgnoreCase(bookId)) {
                current.isAvailable = newStatus;
                System.out.println("Updated availability for Book ID: " + bookId);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found: " + bookId);
    } 
    public void displayForward() {// Display books in forward
        BookNode current = head;
        System.out.println("Books in Forward Order:");
        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    } 
    public void displayReverse() {// Display books in reverse
        BookNode current = tail;
        System.out.println("Books in Reverse Order:");
        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }
    public int countBooks() {// Count total books 
        return totalBooks;
    }
    private void displayBook(BookNode book) {
        System.out.println("Book ID: " + book.bookId + ", Title: " + book.title + 
                           ", Author: " + book.author + ", Genre: " + book.genre + 
                           ", Available: " + (book.isAvailable ? "Yes" : "No"));
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        // Adding books
        library.addAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "B001", true);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Fiction", "B002", true);
        library.addAtPosition(2, "1984", "George Orwell", "Dystopian", "B003", false);
        library.displayForward(); // Displaying books
        library.displayReverse();// Displaying books
        // Searching for books
        library.searchByTitleOrAuthor("1984", null);
        library.searchByTitleOrAuthor(null, "Harper Lee");
        library.updateAvailability("B001", false);//updating booK IS Available
        library.removeByBookId("B002");// removes the book
        library.displayForward();// removes the book
        System.out.println("Total Books in Library: " + library.countBooks());  // Counting 
    }
}
