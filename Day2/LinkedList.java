package Day2;
//package Demo;

class Node {

    int data;
    Node next;

    Node(int info) {
        data = info;
        next = null;
    }
}

public class LinkedList {

    Node head = null;

    // Add node at last
    void addAtLast(int data) {

        Node ptr = new Node(data);

        if (head == null) {
            head = ptr;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = ptr;
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

        LinkedList list = new LinkedList();

        list.addAtLast(10);
        list.addAtLast(20);
        list.addAtLast(30);
        list.addAtLast(40);

        list.show();
    }
}
