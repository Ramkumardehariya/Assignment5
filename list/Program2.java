class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Program2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases (e.g., removing the first node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers: first and second
        ListNode first = dummy;
        ListNode second = dummy;

        // Move the first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Now, second is pointing to the node just before the Nth node from the end
        second.next = second.next.next; // Remove the Nth node

        // Return the new head (in case the original head was removed)
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example to create a list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Program2 remover = new Program2();
        ListNode newHead = remover.removeNthFromEnd(head, 2); // Remove 2nd node from the end

        // Print the updated list
        ListNode current = newHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
