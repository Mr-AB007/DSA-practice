class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteAlternateNode {
    
    // Function to delete alternate nodes in a linked list
    public static void deleteAlternateNode(ListNode head) {
        if (head == null) return; // If the list is empty, do nothing

        ListNode current = head; // Pointer to traverse the list

        while (current != null && current.next != null) {
            current.next = current.next.next; // Skip the next node
            current = current.next; // Move to the next remaining node
        }
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        // Creating a linked list: 1 → 2 → 3 → 4 → 5 → 6 → NULL
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        
        System.out.println("Original List:");
        printList(head);

        deleteAlternateNode(head);

        System.out.println("After Deleting Alternate Nodes:");
        printList(head);
    }
}
