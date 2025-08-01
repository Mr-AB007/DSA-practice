//leetcode 142


// Definition for a singly linked list node
//Time : O(n)
//Space : O(1)
class ListNode {
    int val;       // Stores the value of the node
    ListNode next; // Pointer to the next node

    // Constructor to initialize the node
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {
    /**
     * Detects the start of the cycle in a linked list.
     * If there is a cycle, it returns the node where the cycle begins.
     * If there is no cycle, it returns null.
     *
     * @param head The head of the linked list
     * @return The node where the cycle begins, or null if no cycle exists
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;  // Slow pointer moves 1 step at a time
        ListNode fast = head;  // Fast pointer moves 2 steps at a time

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by 1 step
            fast = fast.next.next;   // Move fast pointer by 2 steps

            if (slow == fast) {  // Cycle detected
                slow = head;  // Reset slow pointer to the head

                // Step 2: Find the start of the cycle
                while (slow != fast) {
                    slow = slow.next;  // Move both pointers one step at a time
                    fast = fast.next;
                }
                return slow;  // Cycle starts at this node
            }
        }
        return null;  // No cycle detected
    }

    public static void main(String[] args) {
        Main solution = new Main();

        // Creating a linked list: 3 → 2 → 0 → -4 → (cycle back to node 2)
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Linking nodes to form a cycle
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // Cycle back to node2

        // Detect cycle
        ListNode cycleStart = solution.detectCycle(node1);
        
        // Print the start of the cycle
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
