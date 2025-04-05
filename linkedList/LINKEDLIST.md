# Linked List in Java

## Overview

A **linked list** is a linear data structure where elements are stored in nodes, and each node points to the next node in the sequence. Unlike arrays, linked lists allow dynamic memory allocation and efficient insertions/deletions.

## Features

- Dynamic size (no fixed memory allocation like arrays)
- Efficient insertion/deletion compared to arrays
- Uses extra memory for storing pointers
- Supports sequential access

## Types of Linked Lists

1. **Singly Linked List** - Each node points to the next node.
2. **Doubly Linked List** - Each node has pointers to both the previous and next nodes.
3. **Circular Linked List** - The last node points back to the first node.

## Singly Linked List

- Each node contains data and a pointer to the next node.
- Allows traversal only in one direction.
- Efficient insertions and deletions compared to arrays.

### Example Code (Singly Linked List)

```java
class SinglyLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }
    private Node head;
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
```

## Doubly Linked List

- Each node contains data, a pointer to the next node, and a pointer to the previous node.
- Allows traversal in both directions (forward and backward).
- More memory usage due to additional pointers but more efficient deletions and insertions in the middle.

### Example Code (Doubly Linked List)

```java
class DoublyLinkedList {
    class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; this.prev = this.next = null; }
    }
    private Node head;
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
```

## Circular Linked List

- Can be singly or doubly linked.
- The last node points back to the first node, forming a loop.
- Useful for buffering applications and scheduling algorithms.

## Implemented Features

- Insert at the beginning, end, and a specific position
- Delete by value
- Search for an element
- Get the size of the linked list
- Display elements

## Time Complexity

| Operation               | Singly Linked List | Doubly Linked List | Circular Linked List |
| ----------------------- | ------------------ | ------------------ | -------------------- |
| Insertion (Beginning)   | O(1)               | O(1)               | O(1)                 |
| Insertion (End)         | O(n)               | O(n)               | O(n)                 |
| Insertion (At Position) | O(n)               | O(n)               | O(n)                 |
| Deletion (By Value)     | O(n)               | O(n)               | O(n)                 |
| Search                  | O(n)               | O(n)               | O(n)                 |
| Display                 | O(n)               | O(n)               | O(n)                 |
| Get Size                | O(1)               | O(1)               | O(1)                 |

## Example Usage

```java
LinkedList list = new LinkedList();
list.insertAtEnd(10);
list.insertAtEnd(20);
list.insertAtEnd(30);
list.insertAtBeginning(5);
list.insertAtPosition(15, 2);
list.display(); // Output: 5 -> 10 -> 15 -> 20 -> 30 -> NULL

list.deleteByValue(15);
list.display(); // Output: 5 -> 10 -> 20 -> 30 -> NULL

System.out.println("Search 20: " + list.search(20)); // Output: true
System.out.println("Size: " + list.getSize()); // Output: 4
```

## Advantages of Linked Lists

- Dynamic memory allocation
- Efficient insertions/deletions
- No memory wastage

## Disadvantages of Linked Lists

- Extra memory for pointers
- Sequential access only (no direct index access)

## Common Problems on Doubly Linked List
1. Reverse a Doubly Linked List
2. Find the Middle of a Doubly Linked List
3. Detect and Remove a Loop (If Formed)
4. Merge Two Sorted Doubly Linked Lists
5. Convert a Binary Tree to a Doubly Linked List
6. Find Pairs in a Doubly Linked List with a Given Sum
7. Delete a Node at a Given Position

## Common Problems on Linked List (Singly & Doubly)
1. Reverse a Linked List:-   [(Solution)](https://github.com/Mr-AB007/DSA-practice/blob/main/linkedList/ReverseLinkedList.java)
2. Detect a Loop in a Linked List:- [(Solution)](https://github.com/Mr-AB007/DSA-practice/blob/main/linkedList/DetectLoopInLinkedList.java)
3. Remove Duplicates from a Sorted Linked List:- [(Solution)](https://github.com/Mr-AB007/DSA-practice/blob/main/linkedList/RemoveDuplicatesSortedLinkedList.java)
4. Find the Intersection of Two Linked Lists:- [(solution)](https://github.com/Mr-AB007/DSA-practice/blob/main/linkedList/FindIntersectionInLinkedList.java)
5. Find the Nth Node from the End
6. Check if a Linked List is Palindrome
7. Flatten a Multilevel Doubly Linked List
8. Rotate a Linked List
9. Add Two Numbers Represented by Linked Lists
10. Clone a Linked List with Random Pointers
11. Remove the Nth Node from the End [(solution)] (https://github.com/Mr-AB007/DSA-practice/blob/main/linkedList/RemoveNthFromEnd.java)

## Conclusion

Linked lists are a fundamental data structure, essential for understanding dynamic memory management, efficient insertions/deletions, and sequential data handling. They are widely used in stacks, queues, and graph implementations.

