class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Program3 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; // No intersection if either list is empty
        }

        // Initialize two pointers to traverse both lists
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists
        // When pointerA reaches the end of listA, switch it to headB
        // When pointerB reaches the end of listB, switch it to headA
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // When pointerA == pointerB, either they intersect at some node or they both reach null
        return pointerA; // This could either be the intersection node or null if there is no intersection
    }

    public static void main(String[] args) {
        // Example to create two intersecting linked lists
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);

        // Creating intersection
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        headA.next.next = intersect; // List A: 4 -> 1 -> 8 -> 4 -> 5
        headB.next.next.next = intersect; // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5

        Program3 solution = new Program3();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);

        if (intersectionNode != null) {
            System.out.println("Intersection point at node with value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection point.");
        }
    }
}
