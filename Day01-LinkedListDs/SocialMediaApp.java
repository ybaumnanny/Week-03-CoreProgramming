/*
 * Singly Linked List: Social Media Friend Connections
Problem Statement: Create a system to manage social media friend connections using a singly linked list. Each node represents a user with User ID, Name, Age, and List of Friend IDs. Implement the following operations:
Add a friend connection between two users.
Remove a friend connection.
Find mutual friends between two users.
Display all friends of a specific user.
Search for a user by Name or User ID.
Count the number of friends for each user.
Hint:
Use a singly linked list where each node contains a list of friends (which can be another linked list or array of Friend IDs).
For mutual friends, traverse both lists and compare the Friend IDs.
The List of Friend IDs for each user can be implemented as a nested linked list or array.

 */

import java.util.ArrayList;

public class SocialMediaApp {

    // Each user is represented as a node in the linked list
    class User {
        int userID;
        String name;
        int age;
        ArrayList<Integer> friendIDs; // Friends' User IDs
        User next; // Pointer to the next user in the list

        User(int userID, String name, int age) {
            this.userID = userID;
            this.name = name;
            this.age = age;
            this.friendIDs = new ArrayList<>();
            this.next = null;
        }
    }

    private User head; // The first user in the linked list

    // Add a new user
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser; // First user
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next; // Move to the end of the list
            }
            current.next = newUser; // Add new user at the end
        }
        System.out.println("User added: " + name);
    }

    // Find a user by ID
    private User findUser(int userID) {
        User current = head;
        while (current != null) {
            if (current.userID == userID) {
                return current;
            }
            current = current.next;
        }
        return null; // User not found
    }

    // Add a friend connection
    public void addFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
        }
        if (!user2.friendIDs.contains(userID1)) {
            user2.friendIDs.add(userID1);
        }

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a user
    public void displayFriends(int userID) {
        User user = findUser(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendID : user.friendIDs) {
            User friend = findUser(friendID);
            if (friend != null) {
                System.out.println("- " + friend.name);
            }
        }
    }

    // Count friends for each user
    public void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println(current.name + " has " + current.friendIDs.size() + " friend(s).");
            current = current.next;
        }
    }

    // Find mutual friends
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        for (int friendID : user1.friendIDs) {
            if (user2.friendIDs.contains(friendID)) {
                User mutualFriend = findUser(friendID);
                if (mutualFriend != null) {
                    System.out.println("- " + mutualFriend.name);
                }
            }
        }
    }

    // Remove a friend connection
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIDs.remove(Integer.valueOf(userID2));
        user2.friendIDs.remove(Integer.valueOf(userID1));

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    public static void main(String[] args) {
        SocialMediaApp app = new SocialMediaApp();

        // Adding users
        app.addUser(1, "Alice", 25);
        app.addUser(2, "Bob", 30);
        app.addUser(3, "Charlie", 22);

        // Adding friend connections
        app.addFriend(1, 2); // Alice and Bob
        app.addFriend(1, 3); // Alice and Charlie

        // Display friends
        app.displayFriends(1); // Alice's friends
        app.displayFriends(2); // Bob's friends

        // Find mutual friends
        app.findMutualFriends(1, 2); // Mutual friends of Alice and Bob

        // Count friends
        app.countFriends();

        // Remove a friend
        app.removeFriend(1, 2); // Remove connection between Alice and Bob

        // Display friends again
        app.displayFriends(1); // Alice's friends after removal
    }
}
