class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveDuplicatesSortedLinkedList {
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) return null; // Edge case: empty list

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip the duplicate node
            } else {
                current = current.next; // Move to the next distinct node
            }
        }
        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] values = {1, 1, 2, 3, 3, 4}; // Example input
        ListNode head = createLinkedList(values);

        System.out.println("Original Linked List:");
        printList(head);

        head = removeDuplicates(head);

        System.out.println("Linked List after removing duplicates:");
        printList(head);
    }
}
