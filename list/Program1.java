class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}


class LinkedList{
    Node head;
    Node tail;

    void insertTail(LinkedList list, int data){
        Node node = new Node(data);

        if(list.head == null){
            head = node;
            tail = node;
        }
        else{
            Node temp = list.head;
            while(temp.next != null){
                temp= temp.next;
            }

            temp.next = node;
            tail = temp.next;
        }
    }
    

    void makCycle(LinkedList list){
        Node curr = list.head;

        Node node = curr.next;

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    int detectCycle(LinkedList list){
        Node curr = list.head;
        Node prev = list.head;

        while (curr != null && curr.next != null) {
            prev = prev.next;
            curr = curr.next.next;

            if(curr == prev){
                prev = list.head;

                while (prev != curr) {
                    prev = prev.next;
                    curr = curr.next;
                }
                return prev.data;
            }
        }
        
        return 0;
    }

    void printList(LinkedList list){
        Node temp = list.head;

        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}



public class Program1 {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertTail(list, 4);
        list.insertTail(list, 5);
        list.insertTail(list, 6);
        list.insertTail(list, 7);
        list.insertTail(list, 8);
        list.insertTail(list, 9);

        list.printList(list);
        list.makCycle(list);

        int num = list.detectCycle(list);

        System.out.println(num);
    }
}
