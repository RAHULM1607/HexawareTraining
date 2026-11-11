package Day2;

class Node1 {
    int data;
    Node next;

    Node1(int info) {
        data = info;
        next = null;
    }
}

public class InsertAtBeg {

    Node head = null;

    // Insert at beginning
    void addAtFirst(int data) {

        Node ptr = new Node(data);

        if (head == null) {
            head = ptr;
        }
        else {
            ptr.next = head;
            head = ptr;
        }
    }

    // Display linked list
    void show() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        InsertAtBeg list = new InsertAtBeg();

        list.addAtFirst(10);
        list.addAtFirst(20);
        list.addAtFirst(30);
        list.addAtFirst(40);

        list.show();
    }
}
