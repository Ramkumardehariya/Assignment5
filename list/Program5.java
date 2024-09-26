class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Program5 {

    // Function to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to serve as the start of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists and merge them
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1; // Append l1's node
                l1 = l1.next;      // Move l1 forward
            } else {
                current.next = l2; // Append l2's node
                l2 = l2.next;      // Move l2 forward
            }
            current = current.next; // Move current forward
        }

        // If any elements are left in either list, append them
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the head of the merged list (next of dummy node)
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create two example sorted linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Program5 solution = new Program5();
        ListNode mergedList = solution.mergeTwoLists(l1, l2);

        // Print the merged sorted list
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
