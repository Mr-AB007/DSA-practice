// Definition of ListNode
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DetectLoopInLinkedList {

    // Function to detect a loop in the linked list (Implement logic here)
    //Floyd’s Cycle Detection Algorithm (also called the slow and fast pointer approach).
    public static boolean hasLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next.next != null){
            if(slow == fast)
                return true;
            fast = fast.next.next; //moving fast pointer faster than other one
            slow = slow.next;
        }

        return false;
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 → 2 → 3 → 4 → 5 → NULL
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Uncomment to create a loop: 5 → 3
         head.next.next.next.next.next = head.next.next;

        if (hasLoop(head)) {
            System.out.println("Loop detected in the linked list!");
        } else {
            System.out.println("No loop detected.");
        }
    }
}
