/*
 * Doubly Linked List Implementation in Java
 * Author: Anubhav Ranjan
 */

// Node class representing each element in the doubly linked list
class Node {
    int data;
    Node prev;
    Node next;

    // Constructor to create a new node
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// DoublyLinkedList class with essential operations
class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete from the end
    public void deleteFromEnd() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Search an element
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Display the list in forward direction
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Display the list in backward direction
    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
}

// Main class to test the implementation
public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        dll.insertAtBeginning(10);
        dll.insertAtBeginning(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        
        System.out.println("Doubly Linked List in Forward Direction:");
        dll.displayForward();
        
        System.out.println("Doubly Linked List in Backward Direction:");
        dll.displayBackward();
        
        dll.deleteFromBeginning();
        System.out.println("After Deleting from Beginning:");
        dll.displayForward();
        
        dll.deleteFromEnd();
        System.out.println("After Deleting from End:");
        dll.displayForward();
        
        System.out.println("Search 30: " + dll.search(30));
        System.out.println("Search 50: " + dll.search(50));
    }
}
