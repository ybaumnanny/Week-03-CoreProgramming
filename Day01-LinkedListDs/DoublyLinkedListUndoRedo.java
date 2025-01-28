
// TextEditorUndoRedo.java
class TextEditorUndoRedo {
    // Node class representing each state in the text history
    private static class Node {
        String text;
        Node prev, next;

        Node(String text) {
            this.text = text;
        }
    }

    private Node head, tail, current;
    private final int MAX_HISTORY; // Maximum number of stored states
    private int size;

    // Constructor to initialize history size
    public TextEditorUndoRedo(int maxHistory) {
        this.MAX_HISTORY = maxHistory;
        this.size = 0;
    }

    // Method to add a new text state to history
    public void addTextState(String text) {
        Node newNode = new Node(text);

        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        } else {
            head = newNode;
        }

        current = newNode;
        tail = newNode;
        size++;

        // Maintain max history size by removing the oldest state if necessary
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Method to undo the last operation
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo operations available.");
        }
    }

    // Method to redo an undone operation
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo operations available.");
        }
    }

    // Method to display the current text state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No text history available.");
        }
    }
}

// Main.java
public class DoublyLinkedListUndoRedo {
    public static void main(String[] args) {
        // Create an instance of the text editor with a maximum history of 10 states
        TextEditorUndoRedo editor = new TextEditorUndoRedo(10);

        // Add text states to the editor
        editor.addTextState("Text Editor Initialized");
        editor.addTextState("Added First Line");
        editor.addTextState("Added Second Line");
        editor.addTextState("Corrected Typo in Second Line");

        editor.displayCurrentState(); // Corrected Typo in Second Line

        // Perform undo operations
        editor.undo();
        editor.displayCurrentState(); // Added Second Line

        editor.undo();
        editor.displayCurrentState(); // Added First Line

        // Perform redo operation
        editor.redo();
        editor.displayCurrentState(); // Added Second Line
    }
}