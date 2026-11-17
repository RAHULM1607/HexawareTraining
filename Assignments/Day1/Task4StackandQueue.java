package Day1Assignment;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


public class Task4StackandQueue {
    static class Order {
        int orderId;
        String customerId;
        BigDecimal amount;
        LocalDateTime createdAt;

        Order(int orderId, String customerId, BigDecimal amount, LocalDateTime createdAt) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.amount = amount;
            this.createdAt = createdAt;
        }

        Order copy() {
            return new Order(orderId, customerId, amount, createdAt);
        }

        public String toString() {
            return "Order ID: " + orderId + ", Customer: " + customerId + ", Amount: " + amount;
        }
    }

    static ArrayList<Order> loadOrders() throws IOException {
        ArrayList<Order> orders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/Day1Assignment/orders.csv"))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int orderId = Integer.parseInt(data[0]);
                String customerId = data[1];
                BigDecimal amount = new BigDecimal(data[2]);
                LocalDateTime createdAt = LocalDateTime.parse(data[3]);

                orders.add(new Order(orderId, customerId, amount, createdAt));
            }
        }
        return orders;
    }

    static void generateOrders(ArrayList<Order> orders) {
        Random random = new Random(42);

        while (orders.size() < 50000) {
            int id = 100001 + orders.size();
            String customer = "C" + (100 + random.nextInt(5000));
            BigDecimal amount = BigDecimal.valueOf(100 + random.nextInt(10000));
            LocalDateTime time = LocalDateTime.of(2026, 11, 10, 10, 0)
                    .plusSeconds(orders.size());

            orders.add(new Order(id, customer, amount, time));
        }
    }

    static ArrayList<Order> getOrders() {
        ArrayList<Order> orders;
        try {
            orders = loadOrders();
            System.out.println("CSV Records Loaded: " + orders.size());
        } catch (IOException e) {
            System.out.println("CSV file not found. Generating sample records.");
            orders = new ArrayList<>();
        }
        generateOrders(orders);
        System.out.println("Total Records Available: " + orders.size());
        return orders;
    }

    static class MyStack<T> {
        Object[] stack = new Object[10];
        int top = -1;

        void push(T value) {
            if (top == stack.length - 1) {
                stack = Arrays.copyOf(stack, stack.length * 2);
            }
            stack[++top] = value;
        }

        @SuppressWarnings("unchecked")
        T pop() {
            if (top == -1) return null;
            T value = (T) stack[top];
            stack[top--] = null;
            return value;
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    static class MyQueue<T> {
        Object[] queue = new Object[10];
        int front = 0;
        int rear = 0;
        int size = 0;

        void enqueue(T value) {
            if (size == queue.length) grow();
            queue[rear] = value;
            rear = (rear + 1) % queue.length;
            size++;
        }

        @SuppressWarnings("unchecked")
        T dequeue() {
            if (size == 0) return null;
            T value = (T) queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            size--;
            return value;
        }

        void grow() {
            Object[] newQueue = new Object[queue.length * 2];
            for (int i = 0; i < size; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }
            queue = newQueue;
            front = 0;
            rear = size;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    static void task4(ArrayList<Order> orders) {
        System.out.println("\\n===== TASK 4: STACK AND QUEUE =====");

        MyStack<Order> myStack = new MyStack<>();
        Order editedOrder = orders.get(0);

        System.out.println("Original Order: " + editedOrder);
        myStack.push(editedOrder.copy());

        editedOrder.amount = editedOrder.amount.add(BigDecimal.valueOf(100));
        System.out.println("After Edit: " + editedOrder);

        Order previous = myStack.pop();
        editedOrder.amount = previous.amount;
        System.out.println("After Undo: " + editedOrder);

        ArrayDeque<Order> builtInStack = new ArrayDeque<>();
        builtInStack.push(orders.get(0).copy());
        System.out.println("\\nBuilt-in Stack Pop: " + builtInStack.pop());

        MyQueue<Order> myQueue = new MyQueue<>();
        for (int i = 0; i < 3; i++) myQueue.enqueue(orders.get(i));

        System.out.println("\\nCustom Queue Dispatch:");
        while (!myQueue.isEmpty()) {
            System.out.println("Dispatched: " + myQueue.dequeue());
        }

        ArrayDeque<Order> builtInQueue = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) builtInQueue.offer(orders.get(i));

        System.out.println("\\nBuilt-in Queue Dispatch:");
        while (!builtInQueue.isEmpty()) {
            System.out.println("Dispatched: " + builtInQueue.poll());
        }

        System.out.println("\\nStack Push/Pop: O(1) amortized");
        System.out.println("Queue Enqueue/Dequeue: O(1) amortized");
    }

    public static void main(String[] args) {
        task4(getOrders());
    }
}
