package org.anubhav;


/*You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists. */

import java.util.Stack;
// Definition for a singly linked list node
class ListNode {
    int val;       // Value of the node
    ListNode next; // Pointer to the next node

    // Constructor for a single node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Constructor for creating a node with a reference to the next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeSortedLists {

    // Function to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Dummy node to act as the starting point of the merged list
        ListNode dummy = new ListNode(0);
        // Pointer to track the last node in the merged list
        ListNode current = dummy;

        // Traverse both lists while neither is exhausted
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { // If l1's value is smaller, append it to merged list
                current.next = l1;
                l1 = l1.next; // Move l1 to the next node
            } else { // If l2's value is smaller or equal, append it to merged list
                current.next = l2;
                l2 = l2.next; // Move l2 to the next node
            }
            current = current.next; // Move merged list pointer forward
        }

        // If any list still has remaining nodes, append them directly
        current.next = (l1 != null) ? l1 : l2;

        // Return the merged list, skipping the dummy node
        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating first sorted linked list: 1 → 3 → 5
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));

        // Creating second sorted linked list: 2 → 4 → 6 → 8 → 10
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, new ListNode(10)))));

        // Merge the two lists
        ListNode mergedHead = mergeTwoLists(l1, l2);

        // Print the merged linked list
        printList(mergedHead);
    }
}
