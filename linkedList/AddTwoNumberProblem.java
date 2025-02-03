/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
   You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

// Definition for a singly-linked list node.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify the result list creation
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;  // Pointer to build the result linked list
        int carry = 0;  // Stores the carry from previous sum

        // Process both linked lists until both are fully traversed
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with the carry from the previous operation
            
            if (l1 != null) {
                sum += l1.val;  // Add digit from first list
                l1 = l1.next;  // Move to the next node
            }
            
            if (l2 != null) {
                sum += l2.val;  // Add digit from second list
                l2 = l2.next;  // Move to the next node
            }

            carry = sum / 10;  // Compute the new carry
            current.next = new ListNode(sum % 10);  // Create new node with the sum digit
            current = current.next;  // Move pointer forward
        }

        return dummy.next;  // Return the resulting linked list (excluding the dummy node)
    }

    // Helper function to create a linked list from an array of integers
    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode();  // Dummy node to simplify list creation
        ListNode current = dummy;  // Pointer to build the list
        for (int val : arr) {
            current.next = new ListNode(val);  // Create new node with current value
            current = current.next;  // Move pointer to the new node
        }
        return dummy.next;  // Return the head of the linked list
    }

    // Helper function to print a linked list in a readable format
    public static void printLinkedList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);  // Append the value to the StringBuilder
            if (node.next != null) {
                sb.append(" -> ");  // Add arrow for readability
            }
            node = node.next;  // Move to the next node
        }
        System.out.println(sb.toString());  // Print the formatted output
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        
        // Input the first number
        int[] arr1 = {2, 4, 3};  // Represents 342
        ListNode l1 = createLinkedList(arr1);
        printLinkedList(l1);
        
        // Input the second number
        int[] arr2 = {5, 6, 4};  // Represents 465
        ListNode l2 = createLinkedList(arr2);
        printLinkedList(l2);

        // Compute the sum
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        System.out.println("Resultant sum as a linked list:");
        printLinkedList(result);  // Expected output: 7 -> 0 -> 8 (Represents 807)
    }
}
