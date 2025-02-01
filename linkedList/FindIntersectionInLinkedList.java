class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class FindIntersectionInLinkedList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Step 1: Find the lengths of both linked lists
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        
        // Step 2: Align the starting points of both lists
        while (lengthA > lengthB) {
            headA = headA.next; // Move headA forward
            lengthA--;
        }
        while (lengthB > lengthA) {
            headB = headB.next; // Move headB forward
            lengthB--;
        }

        // Step 3: Traverse both lists together to find intersection
        while (headA != null && headB != null) {
            if (headA == headB) { // If both pointers meet, return intersection
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null; // No intersection found
    }
    
    // Helper function to find the length of a linked list
    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {

       ListNode linkListA = new ListNode(4);
       linkListA.next = new ListNode(1);
       linkListA.next.next = new ListNode(8);
       linkListA.next.next.next = new ListNode(5);
       linkListA.next.next.next.next = new ListNode(6);
       linkListA.next.next.next.next.next = new ListNode(7);

       ListNode linkListB = new ListNode(9);
       linkListB.next = new ListNode(6);
       linkListB.next.next = new ListNode(1);
       /*
         * List A: 4 → 1 → 8 → 5 → 6 → 7
                             ↑
           List B:9 → 6 → 1 ↗
         */

       linkListB.next.next.next = linkListA.next.next.next; //comment this line for removing intersection       

       ListNode intersection = getIntersectionNode(linkListA,linkListB); 

       if(intersection == null){
        System.out.println("No interction node");
       }else{
        System.out.println("Interction at Node " + intersection.val);
       }
         
    }
}
