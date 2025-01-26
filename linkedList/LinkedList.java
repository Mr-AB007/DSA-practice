public class LinkedList {
    // Node class representing each element in the linked list
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head node of the linked list
    private int size;  // Stores the size of the linked list

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Insert at the beginning (O(1) time complexity)
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Insert at the end (O(n) time complexity)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    // Insert at a specific position (O(n) time complexity)
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // Delete from End
    public void deleteFromEnd() {

        Node temp = head;
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete by value (O(n) time complexity)
    public void deleteByValue(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            size--;
        }
    }

    // Search for a value (O(n) time complexity)
    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    // Get size of the linked list (O(1) time complexity)
    public int getSize() {
        return size;
    }

    // Display linked list elements (O(n) time complexity)
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 2);
        list.display(); // Expected: 5 -> 10 -> 15 -> 20 -> 30 -> NULL
        
        list.deleteByValue(15);

        list.display(); // Expected: 5 -> 10 -> 20 -> 30 -> NULL
        list.deleteFromEnd();
        list.display(); // Expected: 5 -> 10 -> 20 -> NULL

        System.out.println("Search 20: " + list.search(20)); // Expected: true
        System.out.println("Size: " + list.getSize()); // Expected: 4
    }
}
