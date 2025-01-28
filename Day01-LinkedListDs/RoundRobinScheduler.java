/*
 * Circular Linked List: Round Robin Scheduling Algorithm
Problem Statement: Implement a round-robin CPU scheduling algorithm using a circular linked list. Each node will represent a process and contain Process ID, Burst Time, and Priority. Implement the following functionalities:
Add a new process at the end of the circular list.
Remove a process by Process ID after its execution.
Simulate the scheduling of processes in a round-robin manner with a fixed time quantum.
Display the list of processes in the circular queue after each round.
Calculate and display the average waiting time and turn-around time for all processes.
Hint:
Use a circular linked list to represent a queue of processes.
Each process executes for a fixed time quantum, and then control moves to the next process in the circular list.
Maintain the current node as the process being executed, and after each round, update the list to simulate execution.

 */

public class RoundRobinScheduler {
    class Process {
        int processID;
        int burstTime;
        int priority;
        Process next;

        Process(int processID, int burstTime, int priority) {
            this.processID = processID;
            this.burstTime = burstTime;
            this.priority = priority;
            this.next = null;
        }
    }

    private Process head = null;
    private Process tail = null;

    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head; // Circular link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular link
        }
    }

    public void removeProcess(int processID) {
        if (head == null) return;

        Process current = head, prev = null;

        // Traverse and find the process to remove
        do {
            if (current.processID == processID) {
                if (current == head) { // Removing head
                    if (head == tail) { // Only one process
                        head = null;
                        tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else if (current == tail) { // Removing tail
                    prev.next = head;
                    tail = prev;
                } else { // Removing middle node
                    prev.next = current.next;
                }
                return; // Process removed
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalProcesses = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        // Count the total number of processes
        Process temp = head;
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        // Simulate execution
        System.out.println("Starting Round Robin Scheduling...");
        while (head != null) {
            System.out.println("Current Processes:");
            displayProcesses();

            if (head.burstTime > timeQuantum) {
                System.out.println("Executing Process ID: " + head.processID);
                head.burstTime -= timeQuantum;
                tail = head; // Update tail to the current process
                head = head.next; // Move to the next process
            } else {
                System.out.println("Executing Process ID: " + head.processID + " (Completed)");
                totalTurnAroundTime += head.burstTime;
                totalWaitingTime += totalTurnAroundTime;
                int completedProcessID = head.processID;
                removeProcess(completedProcessID);
            }
        }

        System.out.println("\nScheduling Complete.");
        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / (double) totalProcesses));
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process current = head;
        do {
            System.out.print("Process ID: " + current.processID + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        int timeQuantum = 3;
        scheduler.simulateRoundRobin(timeQuantum);
    }
}
