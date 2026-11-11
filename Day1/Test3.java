/**import java.util.Scanner;

class Test3 {

    int queue[] = new int[5];
    int front = -1;
    int rear = -1;

    // ENQUEUE
    void enqueue(int value) {

        if (rear == queue.length - 1) {
            System.out.println("Queue Overflow!");
        }
        else {
            if (front == -1) {
                front = 0;
            }

            rear++;
            queue[rear] = value;

            System.out.println(value + " inserted successfully");
        }
    }

    // DEQUEUE
    void dequeue() {

        if (front == -1) {
            System.out.println("Queue is Empty");
        }
        else {
            System.out.println("Deleted: " + queue[front]);

            if (front == rear) {
                front = rear = -1;
            }
            else {
                front++;
            }
        }
    }

    // SHOW
    void show() {

        if (front == -1) {
            System.out.println("Queue is Empty");
        }
        else {
            System.out.println("Queue Elements:");

            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}

public class Test3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Test3 q = new Test3();

        int choice, value;

        do {
            System.out.println("\n===== QUEUE MENU =====");
            System.out.println("1. ENQUEUE");
            System.out.println("2. DEQUEUE");
            System.out.println("3. SHOW");
            System.out.println("4. EXIT");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.show();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}**/