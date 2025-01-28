class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next, prev;
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private MovieNode head, tail;
    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    // Add a movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    // Add a movie at a specific position
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) current = current.next;
        if (current == null || current == tail) {
            addAtEnd(title, director, year, rating);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }
    // Remove a movie by title
    public void removeByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head) head = head.next;
                if (current == tail) tail = tail.prev;
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                System.out.println("Movie removed: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }
    // Search for movies by Director or Rating
    public void searchByDirectorOrRating(String director, Double rating) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                (rating != null && current.rating == rating)) {
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found.");
    }
    // Update a movie's rating
    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }
    // Display all movies in forward order
    public void displayForward() {
        MovieNode current = head;
        System.out.println("Movies in Forward Order:");
        while (current != null) {
            displayMovie(current);
            current = current.next;
        }
    }
    // Display all movies in reverse order
    public void displayReverse() {
        MovieNode current = tail;
        System.out.println("Movies in Reverse Order:");
        while (current != null) {
            displayMovie(current);
            current = current.prev;
        }
    }
    // Helper to display a single movie
    private void displayMovie(MovieNode movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director + 
                           ", Year: " + movie.year + ", Rating: " + movie.rating);
    }
}
public class MovieManagementSystem {
    public static void main(String[] args) {
        DoublyLinkedList movies = new DoublyLinkedList();
        // Adding movies
        movies.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movies.addAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movies.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6);
        // Displaying movies
        movies.displayForward();
        movies.displayReverse();
        // Searching for movies
        movies.searchByDirectorOrRating("Christopher Nolan", null);
        movies.searchByDirectorOrRating(null, 9.2);
        // Updating movie rating
        movies.updateRating("Inception", 9.0);
        // Removing a movie
        movies.removeByTitle("The Godfather");
        movies.displayForward();
    }
}
