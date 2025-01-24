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

## Doubly Linked List

- Each node contains data, a pointer to the next node, and a pointer to the previous node.
- Allows traversal in both directions (forward and backward).
- More memory usage due to additional pointers but more efficient deletions and insertions in the middle.

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

## How to Run

1. Compile the `LinkedList.java` file:
   ```sh
   javac LinkedList.java
   ```
2. Run the compiled class:
   ```sh
   java LinkedList
   ```

## Advantages of Linked Lists

- Dynamic memory allocation
- Efficient insertions/deletions
- No memory wastage

## Disadvantages of Linked Lists

- Extra memory for pointers
- Sequential access only (no direct index access)

## Conclusion

Linked lists are a fundamental data structure, essential for understanding dynamic memory management, efficient insertions/deletions, and sequential data handling. They are widely used in stacks, queues, and graph implementations.
