package Day2;


class Node3 {
    int data;
    Node next;

    Node3(int info) {
        data = info;
        next = null;
    }
}

public class DeleteLL {

    Node head = null;

    // Insert at last
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

    // Delete at specific position
    void deleteAtPosition(int pos) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        int l = 1;
        Node temp = head;
        Node save = null;

        while (temp != null) {

            if (l == pos) {
                save.next = temp.next;
                temp = null;
                return;
            }

            save = temp;
            temp = temp.next;
            l++;
        }

        System.out.println("Invalid position");
    }

    // Display
    void show() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DeleteLL list = new DeleteLL();

        list.addAtLast(10);
        list.addAtLast(20);
        list.addAtLast(30);
        list.addAtLast(40);

        System.out.println("Before deletion:");
        list.show();

        list.deleteAtPosition(2);

        System.out.println("After deletion:");
        list.show();
    }
}

