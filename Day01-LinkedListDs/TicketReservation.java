class TicketReservationSystem {
    // Node class representing a booked ticket
    private static class TicketNode {
        int ticketID;
        String customerName;
        String movieName;
        int seatNumber;
        String bookingTime;
        TicketNode next;

        TicketNode(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
            this.ticketID = ticketID;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode last;
    private int totalTickets;

    public TicketReservationSystem() {
        this.last = null;
        this.totalTickets = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            // First node points to itself
            last = newNode;
            last.next = last;
        } else {
            // Insert new node at the end and update circular link
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        totalTickets++;
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = last.next, prev = last;
        do {
            if (current.ticketID == ticketID) {
                if (current == last && current.next == last) {
                    last = null; // Removing the only node
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev; // Update last if last is being removed
                    }
                }
                totalTickets--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket ID not found.");
    }

    // Display all current tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }
        TicketNode current = last.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket - Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No matching tickets found.");
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }
}

class TicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(101, "Alice", "Inception", 5, "12:30 PM");
        system.addTicket(102, "Bob", "Avatar", 7, "3:00 PM");
        system.addTicket(103, "Charlie", "Interstellar", 10, "6:45 PM");

        System.out.println("Current Tickets:");
        system.displayTickets();

        System.out.println("Searching for 'Avatar':");
        system.searchTicket("Avatar");

        System.out.println("Removing Ticket ID 102");
        system.removeTicket(102);

        System.out.println("Tickets after removal:");
        system.displayTickets();

        System.out.println("Total Tickets: " + system.getTotalTickets());
    }
}