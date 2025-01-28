// Definition of ListNode
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {

    // Function to reverse a linked list (Implement logic here)
    public static ListNode reverse(ListNode head) {
       ListNode prev=null,current=head;

       while(current != null){
        ListNode next = current.next; // Store next node
        current.next = prev; // Reverse the link
        prev = current; // Move prev forward
        current = next; // Move current forward
       }
        return prev;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 → 2 → 3 → 4 → 5 → NULL
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Call the reverse function (Implement the logic in reverse method)
        head = reverse(head);

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}
