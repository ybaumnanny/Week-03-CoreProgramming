/*Singly Linked List: Student Record Management
Problem Statement: Create a program to manage student records using a singly linked list.
Each node will store information about a student, including their Roll Number, Name, Age, and Grade.
Implement the following operations:
Add a new student record at the beginning, end, or at a specific position.
Delete a student record by Roll Number.
Search for a student record by Roll Number.
Display all student records.
Update a student's grade based on their Roll Number.
Hint:
Use a singly linked list where each node contains student information and a pointer to the next node.
The head of the list will represent the first student, and the last node’s next pointer will be null.
Update the next pointers when inserting or deleting nodes.*/

class StudentNode{
    protected String rollNumber;
    protected String name;
    protected int age;
    protected char grade;
    StudentNode next;

    //Constructor
    StudentNode(String rollNumber, String name, int age, char grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentLinkedList{
    private StudentNode head;

    //To add at the beg
    public void atTheBeginning(String rollNumber, String name, int age, char grade){
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        newStudent.next = head;
        head= newStudent;
    }

    //To add at the end
    public void atTheEnd(String rollNumber, String name, int age, char grade){
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        if(head == null){
            head = newStudent;
            return;
        }
        StudentNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    //To add at specific position
    public void atTheSpecificPosition(String rollNumber, String name, int age, char grade, int position){

        if(position < 0){
            System.out.println("Invalid position");
            return;
        }
        if(position == 0){
            atTheBeginning(rollNumber, name, age, grade);
            return;
        }

        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        StudentNode temp = head;
        for(int i = 0; temp != null && i < position-1;i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Position out of range.");
            return;
        }

        newStudent.next = temp.next;
        temp.next=newStudent;
    }

    public void displayLinkedList(){
        if(head == null){
            System.out.println("No Records...");
        }
        StudentNode temp = head;
        while (temp != null){
            System.out.println("Roll number: " + temp.rollNumber + " | Name: " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    //Delete a student record by Roll Number.
    public void deleteData(String rollNumber){
        if(head == null){
            System.out.println("List is empty...");
            return;
        }
        if(head.rollNumber.equals(rollNumber)){
            head=head.next;
            return;
        }
        StudentNode temp = head, prev = null;
        while(temp!=null && temp.rollNumber!=rollNumber) {
            prev = temp;
            temp = temp.next;
        }

        //This means we have traverse through the list but we did not found the roll number
        if(temp==null){
            System.out.println("Roll Number not found...");
            return;
        }
        prev.next = temp.next;
    }

    //To Search Data
    public void searchData(String rollNumber){
        StudentNode temp= head;
        while(temp!=null){
            if(temp.rollNumber.equals(rollNumber)){
                System.out.println("----Student Found---- \nRoll Number: " + temp.rollNumber + " | Name: " + temp.name + " | Age: " + temp.age + " | Grade: "+ temp.grade);
                return;
            }
            temp=temp.next;
        }
        System.out.println("----Student not found----");
    }

    //To update Data
    public void updateData(String rollNumber, char newGrade){
        StudentNode temp= head;
        while(temp!=null){
            if(temp.rollNumber.equals(rollNumber)){
                temp.grade = newGrade;
                System.out.println("----Record Updated--- \nRoll Number: " + temp.rollNumber + " | Name: " + temp.name + " | Age: " + temp.age + " | Grade: "+ temp.grade);
                return;
            }
            temp=temp.next;
        }
        System.out.println("----Student not found----");
    }

}

public class StudentRecordManagement{
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.atTheBeginning("179","Vidhi",21,'A');
        list.atTheEnd("183","Yaman",21,'A');
        list.atTheSpecificPosition("078","Kapil",21,'A',1);
        list.displayLinkedList();
        System.out.println();
        list.deleteData("078");
        list.displayLinkedList();
        System.out.println();
        list.searchData("179");
        list.updateData("183",'B');
    }
}