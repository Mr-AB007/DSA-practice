class RemoveNthFromEnd {

//two poniter approach
  public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to simplify edge cases (e.g., removing the head)
        ListNode dummy = new ListNode(0,head);
        

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move the fast pointer 'n + 1' steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the node to be removed
        slow.next = slow.next.next;

        // Return the new head
        return dummy.next;
  }
  //brute force approach 2 time iteration
    public ListNode removeNthFromEndBrute(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode current = head;
        int size = 0;

        // Step 1: Calculate the size of the list
        while (current != null) {
            size++;
            current = current.next;
        }

        // Step 2: Find the node to remove from the beginning
        int indexToRemove = size - n;

        // Step 3: If it's the first node
        if (indexToRemove == 0) {
            return head.next;
        }

        // Step 4: Traverse to the node before the one we want to remove
        current = head;
        for (int i = 1; i < indexToRemove; i++) {
            current = current.next;
        }

        // Step 5: Remove the node
        current.next = current.next.next;

        return head;
    }
}
