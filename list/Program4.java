class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Program4 {

    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a list with one node is always a palindrome
        }

        // Step 1: Use two pointers (slow and fast) to find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow by 1 step
            fast = fast.next.next;     // Move fast by 2 steps
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalfHead = reverseList(slow);

        // Step 3: Compare the first half with the reversed second half
        ListNode firstHalfHead = head;
        ListNode secondHalfIterator = secondHalfHead;
        boolean isPalindrome = true;
        
        while (secondHalfIterator != null) {
            if (firstHalfHead.val != secondHalfIterator.val) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfIterator = secondHalfIterator.next;
        }

        // Step 4 (optional): Restore the original list (re-reverse the second half)
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Example to create a palindrome linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Program4 solution = new Program4();
        boolean result = solution.isPalindrome(head);

        System.out.println("Is the linked list a palindrome? " + result);
    }
}
