/*
203. Remove Linked List Elements

Problem Statement:
Given the head of a linked list and an integer `val`, remove all nodes of the linked list that have `Node.val == val`, and return the new head.
*/

// class ListNode {
//     int val;
//     ListNode next;
    
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

public class RemoveLinkedListElements {
    
    // Function to remove elements from the linked list
//#Time O(n)
//#Space O(1)
    public static ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases like removing the head node
        ListNode ans = new ListNode(0, head);
        ListNode dummy = ans;
        
        // Iterate through the list and remove nodes with the given value
        while (dummy.next != null) {
            if (dummy.next.val == val) {
                dummy.next = dummy.next.next; // Skip the node
            } else {
                dummy = dummy.next; // Move to the next node
            }
        }
        
        return ans.next; // Return the updated list without dummy node
    }


    
  // Recursive approach to remove elements from the linked list(better performance)

//#Time O(n)
//#Space O(n)
    public static ListNode removeElementsRecursive(ListNode head, int val) {
        // Base case: If the list is empty, return null
        if (head == null) return null;
        
        // Recursively call for the next node
        head.next = removeElementsRecursive(head.next, val);
        
        // If current node value matches 'val', skip it by returning head.next
        return (head.val == val) ? head.next : head;
    }

}
}
