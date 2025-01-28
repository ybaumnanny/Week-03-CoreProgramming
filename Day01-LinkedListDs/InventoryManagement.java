/*Singly Linked List: Inventory Management System
Problem Statement: Design an inventory management system using a singly linked list where each node stores
information about an item such as Item Name, Item ID, Quantity, and Price. Implement the following functionalities:
Add an item at the beginning, end, or at a specific position.
Remove an item based on Item ID.
Update the quantity of an item by Item ID.
Search for an item based on Item ID or Item Name.
Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
Sort the inventory based on Item Name or Price in ascending or descending order.
Hint:
Use a singly linked list where each node represents an item in the inventory.
Implement sorting using an appropriate algorithm (e.g., merge sort) on the linked list.
For total value calculation, traverse through the list and sum up Quantity * Price for each item.*/

class InventoryNode{
    protected String itemName;
    protected int itemID;
    protected int quantity;
    protected  double price;
    InventoryNode next;

    //Constructor
    InventoryNode(String itemName, int itemID, int quantity, double price){
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
class InventoryLinkedList{
    private InventoryNode head;

    //To add an item at the beginning
    public void addAtBeginning(String itemName, int itemID, int quantity, double price){
        InventoryNode newInventory = new InventoryNode(itemName, itemID, quantity, price);
        newInventory.next=head;
        head = newInventory;
    }

    //To add an item at the end
    public void addAtEnd(String itemName, int itemID, int quantity, double price){
        InventoryNode newInventory = new InventoryNode(itemName, itemID, quantity, price);
        if(head == null){
            head = newInventory;
            return;
        }
        InventoryNode current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = newInventory;
    }

    //To add an item at a Specific Position
    public void addAtPosition(String itemName, int itemID, int quantity, double price, int position){
        if(position<0){
            System.err.println("Invalid position!");
            return;
        }
        if(position == 0){
            addAtBeginning(itemName, itemID, quantity, price);
            return;
        }
        InventoryNode newInventory = new InventoryNode(itemName, itemID, quantity, price);
        InventoryNode current = head;
        for(int i = 0; current!=null && i<position-1;i++){
            current = current.next;
        }
        if(current == null){
            System.err.println("Position out of range!");
            return;
        }
        newInventory.next = current.next;
        current.next = newInventory;
    }

    //Removing an item based on Item ID.
    public void removingData(int itemID){
        if(head == null){
            System.err.println("List is empty!");
            return;
        }
        if(head.itemID == itemID){
            head = head.next;
            return;
        }
        InventoryNode current = head, prev = null;
        while(current!=null && current.itemID != itemID){
            prev = current;
            current = current.next;
        }
        if(current == null){
            //This means we have traverse through the list but we did not found item
            System.out.println("Item to be deleted do not present in list!");
            return;
        }
        prev.next = current.next;
    }

    //Updating the quantity of an item by Item ID.
    public void updateItemQuantity(int itemID, int quantity){
        InventoryNode current = head;
        while (current!=null){
            if(current.itemID == itemID){
                current.quantity = quantity;
                System.out.println("Item Data Updated--- \nItem name: " + current.itemName + " | ItemId: " + current.itemID + " | Quantity: " + current.quantity + " | Price: " + current.price );
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID doesn't exist!");
    }

    //Search for an item based on Item ID or Item Name.
    public void searchItemID(int itemID){
        InventoryNode current = head;
        while (current!=null){
            if(current.itemID == itemID){
                System.out.println("Item found--- \nItemId: " + current.itemID + " | Item name: " + current.itemName + " | Quantity: " + current.quantity + " | Price: " + current.price );
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID doesn't exist!");
    }
    public void searchItemName(String itemName){
        InventoryNode current = head;
        while (current!=null){
            if(itemName.equalsIgnoreCase(current.itemName)){
                System.out.println("Item found--- \nItemId: " + current.itemID + " | Item name: " + current.itemName + " | Quantity: " + current.quantity + " | Price: " + current.price );
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID doesn't exist!");
    }

    //Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
    public void calculateTotalValue() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        double totalValue = 0;
        InventoryNode current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total Value of Inventory: " + totalValue);
    }

    //Sort inventory based on Item Name or Price in ascending or descending order
    public void sortInventory(String criterion, boolean ascending) {
        if (head == null || head.next == null) return; // If list is empty or has only one element

        InventoryNode sortedList = null;
        InventoryNode current = head;
        while (current != null) {
            InventoryNode nextNode = current.next;
            sortedList = insertSorted(sortedList, current, criterion, ascending);
            current = nextNode;
        }
        head = sortedList;
    }

    //Helper method to insert nodes in sorted order
    private InventoryNode insertSorted(InventoryNode head, InventoryNode newNode, String criterion, boolean ascending) {
        if (head == null || compareNodes(newNode, head, criterion, ascending) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            InventoryNode current = head;
            while (current.next != null && compareNodes(newNode, current.next, criterion, ascending) >= 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return head;
    }

    //Compare nodes based on Item Name or Price
    private int compareNodes(InventoryNode node1, InventoryNode node2, String criterion, boolean ascending) {
        int comparison = 0;
        if (criterion.equalsIgnoreCase("name")) {
            comparison = node1.itemName.compareTo(node2.itemName);
        } else if (criterion.equalsIgnoreCase("price")) {
            comparison = Double.compare(node1.price, node2.price);
        }

        return ascending ? comparison : -comparison; // Reverse order for descending
    }


    //To display the records
    public void displayDetails(){
        if(head == null){
            System.out.println("No item in list!");
            return;
        }
        InventoryNode current = head;
        while(current!= null){
            System.out.println("Item name: " + current.itemName + " | Item ID: " + current.itemID + " | Quantity: " + current.quantity + " | Price: " + current.price);
            current = current.next;
        }
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        InventoryLinkedList list = new InventoryLinkedList();
        list.addAtBeginning("Notebook",1,2,50);
        list.addAtEnd("Pen",2,5,10);
        list.addAtBeginning("Book",3,1,200);
        list.addAtPosition("Spoon",4,12,15,2);
        list.displayDetails();
        System.out.println();
        list.removingData(2);//removing data based on item id
        list.displayDetails();
        System.out.println();
        list.updateItemQuantity(1,5);//updating the quantity on basis of item id
        list.searchItemID(7);//Searching through item ID
        list.searchItemName("Spoon");//Searching through item name
        list.calculateTotalValue();//Calculation total value
        //Sorting Inventory by Item Name in Ascending Order
        System.out.println("\nSorting Inventory by Item Name (Ascending):");
        list.sortInventory("name", true);
        list.displayDetails();
        //Sorting Inventory by Price in Descending Order
        System.out.println("\nSorting Inventory by Price (Descending):");
        list.sortInventory("price", false);
        list.displayDetails();
    }
}