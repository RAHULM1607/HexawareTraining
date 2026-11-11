package Day2;


class Node2 {
    int data;
    Node next;

    Node2(int info) {
        data = info;
        next = null;
    }
}

public class InsertAtPos {

    Node head = null;

    // Insert at specific position
    void addAtPosition(int data, int pos) {

        Node ptr = new Node(data);

        if (pos == 1) {
            ptr.next = head;
            head = ptr;
            return;
        }

        int l = 1;
        Node temp = head;

        while (temp != null) {

            if (l == pos - 1) {

                ptr.next = temp.next;
                temp.next = ptr;
                return;
            }

            temp = temp.next;
            l++;
        }

        System.out.println("Invalid position");
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

        InsertAtPos list = new InsertAtPos();

        list.addAtPosition(10, 1);
        list.addAtPosition(20, 2);
        list.addAtPosition(30, 3);

        list.addAtPosition(40, 2);

        list.show();
    }
}
