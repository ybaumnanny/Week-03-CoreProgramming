class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class CircularLinkedList {
    private TaskNode head = null;
    private TaskNode tail = null;
    // Add a task at the beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Point to itself (circular structure)
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular structure
        }
        System.out.println("Task added at the beginning.");
    }
    // Add a task at the end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular structure
        }
        System.out.println("Task added at the end.");
    }
    // Add a task at a specific position
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        TaskNode current = head;
        int count = 1;
        while (count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }
        if (count == position - 1) {
            newNode.next = current.next;
            current.next = newNode;
            if (current == tail) {
                tail = newNode; // Update tail if added at the end
            }
            System.out.println("Task added at position " + position);
        } else {
            System.out.println("Position out of bounds!");
        }
    }
    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("The list is empty. No task to remove.");
            return;
        }
        TaskNode current = head;
        TaskNode previous = null;
        do {
            if (current.taskId == taskId) {
                if (current == head) { // Deleting head
                    head = head.next;
                    tail.next = head; // Maintain circular structure
                } else if (current == tail) { // Deleting tail
                    tail = previous;
                    tail.next = head;
                } else { // Deleting from the middle
                    previous.next = current.next;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task with ID " + taskId + " not found.");
    }
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("The list is empty. No current task.");
            return;
        }
        System.out.println("Current Task:");
        displayTask(head);
        head = head.next; // Move to the next task
    }
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        TaskNode current = head;
        System.out.println("All Tasks:");
        do {
            displayTask(current);
            current = current.next;
        } while (current != head);
    }
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("The list is empty. No tasks to search.");
            return;
        }
        TaskNode current = head;
        boolean found = false;
        System.out.println("Tasks with Priority " + priority + ":");
        do {
            if (current.priority == priority) {
                displayTask(current);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tasks found with Priority " + priority);
        }
    }
    // Helper method to display a task
    private void displayTask(TaskNode task) {
        System.out.println("Task ID: " + task.taskId + ", Name: " + task.taskName + ", Priority: " + task.priority
                + ", Due Date: " + task.dueDate);
    }
}
public class TaskScheduler {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();
        // Adding tasks
        scheduler.addTaskAtEnd(1, "Task 1", 3, "2025-02-01");
        scheduler.addTaskAtBeginning(2, "Task 2", 2, "2025-01-30");
        scheduler.addTaskAtPosition(2, 3, "Task 3", 1, "2025-02-15");
        // Displaying all tasks
        scheduler.displayAllTasks();
        // Removing a task
        scheduler.removeTaskById(2);
        // Viewing the current task and moving to the next
        scheduler.viewCurrentTask();
        // Searching for tasks by priority
        scheduler.searchTaskByPriority(1);
        scheduler.displayAllTasks();
    }
}
