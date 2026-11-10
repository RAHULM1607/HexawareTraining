
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class RetailOrderDesk {

    // ORDER CLASS
    static class Order {
        int orderId;
        String customerId;
        BigDecimal amount;
        LocalDateTime createdAt;

        Order(int orderId, String customerId,
              BigDecimal amount, LocalDateTime createdAt) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.amount = amount;
            this.createdAt = createdAt;
        }

        Order copy() {
            return new Order(orderId, customerId,
                    amount, createdAt);
        }

        public String toString() {
            return "Order ID: " + orderId +
                    ", Customer: " + customerId +
                    ", Amount: " + amount;
        }
    }

    // LOAD CSV FILE
    static ArrayList<Order> loadOrders()
            throws IOException {

        ArrayList<Order> orders = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader("orders.csv"))) {

            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int orderId = Integer.parseInt(data[0]);
                String customerId = data[1];
                BigDecimal amount = new BigDecimal(data[2]);

                LocalDateTime createdAt =
                        LocalDateTime.parse(data[3]);

                orders.add(new Order(orderId, customerId,
                        amount, createdAt));
            }
        }

        return orders;
    }

    // GENERATE EXTRA RECORDS FOR BENCHMARKING
    static void generateOrders(ArrayList<Order> orders) {

        Random random = new Random(42);

        while (orders.size() < 50000) {

            int id = 100001 + orders.size();

            String customer = "C" + (100 + random.nextInt(5000));

            BigDecimal amount =
                    BigDecimal.valueOf(100 + random.nextInt(10000));

            LocalDateTime time =
                    LocalDateTime.of(2026, 11, 10, 10, 0)
                            .plusSeconds(orders.size());

            orders.add(new Order(id, customer, amount, time));
        }
    }

    // ==========================================
    // TASK 1: LINEAR SEARCH AND BINARY SEARCH
    // ==========================================

    static Order linearSearch(ArrayList<Order> orders,
                              int targetId) {

        for (Order order : orders) {

            if (order.orderId == targetId) {
                return order;
            }
        }

        return null;
    }

    static Order binarySearch(ArrayList<Order> orders,
                              int targetId) {

        int left = 0;
        int right = orders.size() - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (orders.get(mid).orderId == targetId) {
                return orders.get(mid);
            }

            else if (orders.get(mid).orderId < targetId) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return null;
    }

    static void task1(ArrayList<Order> orders) {

        System.out.println("\n===== TASK 1: SEARCHING =====");

        // Use the last order to test a worst-case linear search
        int targetId = orders.get(orders.size() - 1).orderId;

        // Sort by order ID for binary search
        ArrayList<Order> sortedOrders =
                new ArrayList<>(orders);

        sortedOrders.sort(
                Comparator.comparingInt(o -> o.orderId));

        long start = System.nanoTime();

        Order result1 = null;

        for (int i = 0; i < 1000; i++) {
            result1 = linearSearch(orders, targetId);
        }

        long linearTime =
                System.nanoTime() - start;

        start = System.nanoTime();

        Order result2 = null;

        for (int i = 0; i < 1000; i++) {
            result2 = binarySearch(sortedOrders, targetId);
        }

        long binaryTime =
                System.nanoTime() - start;

        System.out.println("Target Order ID: " + targetId);
        System.out.println("Linear Search Result: " + result1);
        System.out.println("Binary Search Result: " + result2);

        System.out.println("Linear Search (1000 runs): "
                + linearTime + " ns");

        System.out.println("Binary Search (1000 runs): "
                + binaryTime + " ns");

        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n)");
        System.out.println("Note: Binary search requires sorted data.");
    }

    // ==========================================
    // TASK 2: BUBBLE SORT AND MERGE SORT
    // ==========================================

    // O(n^2) BUBBLE SORT - DESCENDING
    static void bubbleSort(ArrayList<Order> orders) {

        int n = orders.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders.get(j).amount.compareTo(
                        orders.get(j + 1).amount) < 0) {

                    Order temp = orders.get(j);

                    orders.set(j, orders.get(j + 1));

                    orders.set(j + 1, temp);
                }
            }
        }
    }

    // O(n log n) MERGE SORT - DESCENDING
    static void mergeSort(ArrayList<Order> orders) {

        if (orders.size() <= 1) {
            return;
        }

        int mid = orders.size() / 2;

        ArrayList<Order> left =
                new ArrayList<>(orders.subList(0, mid));

        ArrayList<Order> right =
                new ArrayList<>(orders.subList(mid, orders.size()));

        mergeSort(left);
        mergeSort(right);

        merge(orders, left, right);
    }

    static void merge(ArrayList<Order> orders,
                      ArrayList<Order> left,
                      ArrayList<Order> right) {

        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {

            if (left.get(i).amount.compareTo(
                    right.get(j).amount) >= 0) {

                orders.set(k++, left.get(i++));

            } else {

                orders.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            orders.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            orders.set(k++, right.get(j++));
        }
    }

    static void task2(ArrayList<Order> orders) {

        System.out.println("\n===== TASK 2: SORTING =====");

        // Use first 10000 records
        ArrayList<Order> original =
                new ArrayList<>(orders.subList(0, 10000));

        ArrayList<Order> bubble =
                new ArrayList<>(original);

        ArrayList<Order> merge =
                new ArrayList<>(original);

        ArrayList<Order> builtIn =
                new ArrayList<>(original);

        long start = System.nanoTime();

        bubbleSort(bubble);

        long bubbleTime =
                System.nanoTime() - start;

        start = System.nanoTime();

        mergeSort(merge);

        long mergeTime =
                System.nanoTime() - start;

        start = System.nanoTime();

        builtIn.sort(
                (a, b) -> b.amount.compareTo(a.amount));

        long builtInTime =
                System.nanoTime() - start;

        System.out.println("Records Sorted: 10000");

        System.out.println("Bubble Sort Time: "
                + bubbleTime + " ns");

        System.out.println("Merge Sort Time: "
                + mergeTime + " ns");

        System.out.println("Built-in Sort Time: "
                + builtInTime + " ns");

        System.out.println("\nTop 5 Orders by Amount:");

        for (int i = 0; i < 5; i++) {
            System.out.println(builtIn.get(i));
        }

        System.out.println("\nBubble Sort: O(n^2)");
        System.out.println("Merge Sort: O(n log n)");
        System.out.println("Built-in TimSort: O(n log n) worst case");

        // First three passes of bubble sort on a small example
        System.out.println("\nBubble Sort Pass Demonstration:");

        int[] arr = {50, 20, 80, 10, 40};

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] < arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println("Pass " + (i + 1)
                    + ": " + Arrays.toString(arr));
        }
    }

    // ==========================================
    // TASK 3: DUPLICATE ORDER DETECTION
    // ==========================================

    static void task3(ArrayList<Order> orders) {

        System.out.println("\n===== TASK 3: DUPLICATE DETECTION =====");

        HashMap<String, Order> map = new HashMap<>();

        int duplicateCount = 0;

        for (Order order : orders) {

            // Compare customer, amount and same minute
            String key = order.customerId + "|" +
                    order.amount.stripTrailingZeros().toPlainString()
                    + "|" +
                    order.createdAt.truncatedTo(ChronoUnit.MINUTES);

            if (map.containsKey(key)) {

                System.out.println("Duplicate Order Found:");
                System.out.println("Original: " + map.get(key));
                System.out.println("Duplicate: " + order);

                duplicateCount++;

            } else {

                map.put(key, order);
            }
        }

        System.out.println("Total Duplicate Orders: "
                + duplicateCount);

        System.out.println("Time Complexity: O(n) average");
        System.out.println("Space Complexity: O(n)");
    }

    // ==========================================
    // TASK 4: OWN STACK AND QUEUE
    // ==========================================

    // CUSTOM STACK
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

            if (top == -1) {
                return null;
            }

            T value = (T) stack[top];

            stack[top--] = null;

            return value;
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    // CUSTOM QUEUE
    static class MyQueue<T> {

        Object[] queue = new Object[10];

        int front = 0;
        int rear = 0;
        int size = 0;

        void enqueue(T value) {

            if (size == queue.length) {
                grow();
            }

            queue[rear] = value;

            rear = (rear + 1) % queue.length;

            size++;
        }

        @SuppressWarnings("unchecked")
        T dequeue() {

            if (size == 0) {
                return null;
            }

            T value = (T) queue[front];

            queue[front] = null;

            front = (front + 1) % queue.length;

            size--;

            return value;
        }

        void grow() {

            Object[] newQueue =
                    new Object[queue.length * 2];

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

        System.out.println("\n===== TASK 4: STACK AND QUEUE =====");

        // STACK: UNDO LAST ORDER EDIT
        MyStack<Order> myStack = new MyStack<>();

        Order editedOrder = orders.get(0);

        System.out.println("Original Order: " + editedOrder);

        // Save previous state before editing
        myStack.push(editedOrder.copy());

        editedOrder.amount =
                editedOrder.amount.add(BigDecimal.valueOf(100));

        System.out.println("After Edit: " + editedOrder);

        // Undo operation
        Order previous = myStack.pop();

        editedOrder.amount = previous.amount;

        System.out.println("After Undo: " + editedOrder);

        // BUILT-IN STACK USING ARRAYDEQUE
        ArrayDeque<Order> builtInStack = new ArrayDeque<>();

        builtInStack.push(orders.get(0).copy());

        System.out.println("\nBuilt-in Stack Pop: "
                + builtInStack.pop());

        // CUSTOM QUEUE: DISPATCH LINE
        MyQueue<Order> myQueue = new MyQueue<>();

        for (int i = 0; i < 3; i++) {
            myQueue.enqueue(orders.get(i));
        }

        System.out.println("\nCustom Queue Dispatch:");

        while (!myQueue.isEmpty()) {
            System.out.println("Dispatched: "
                    + myQueue.dequeue());
        }

        // BUILT-IN QUEUE
        ArrayDeque<Order> builtInQueue = new ArrayDeque<>();

        for (int i = 0; i < 3; i++) {
            builtInQueue.offer(orders.get(i));
        }

        System.out.println("\nBuilt-in Queue Dispatch:");

        while (!builtInQueue.isEmpty()) {
            System.out.println("Dispatched: "
                    + builtInQueue.poll());
        }

        System.out.println("\nStack Push/Pop: O(1) amortized");
        System.out.println("Queue Enqueue/Dequeue: O(1) amortized");
    }

    // ==========================================
    // TASK 5: GREEDY AND DYNAMIC PROGRAMMING
    // ==========================================

    // GREEDY APPROACH
    static int greedyCoins(int[] coins, int amount) {

        int count = 0;

        Arrays.sort(coins);

        for (int i = coins.length - 1; i >= 0; i--) {

            int number = amount / coins[i];

            count += number;

            amount = amount % coins[i];
        }

        if (amount != 0) {
            return -1;
        }

        return count;
    }

    // DYNAMIC PROGRAMMING APPROACH
    static int dpCoins(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {

                    dp[i] = Math.min(
                            dp[i],
                            dp[i - coin] + 1
                    );
                }
            }
        }

        if (dp[amount] > amount) {
            return -1;
        }

        return dp[amount];
    }

    static void task5() {

        System.out.println("\n===== TASK 5: GREEDY AND DP =====");

        // Example where greedy works
        int[] normalCoins = {1, 5, 10, 25};

        int refund = 63;

        System.out.println("Refund Amount: " + refund);

        System.out.println("Greedy Result: "
                + greedyCoins(normalCoins, refund));

        System.out.println("DP Result: "
                + dpCoins(normalCoins, refund));

        // Example where greedy fails
        int[] specialCoins = {1, 3, 4};

        int amount = 6;

        System.out.println("\nGreedy Failure Example");

        System.out.println("Coin Denominations: "
                + Arrays.toString(specialCoins));

        System.out.println("Amount: " + amount);

        System.out.println("Greedy Result: "
                + greedyCoins(specialCoins, amount));

        System.out.println("DP Result: "
                + dpCoins(specialCoins, amount));

        System.out.println("\nGreedy Complexity: O(n log n)");
        System.out.println("DP Complexity: O(amount * n)");
        System.out.println("DP Space Complexity: O(amount)");
    }

    // ==========================================
    // MAIN METHOD
    // ==========================================

    public static void main(String[] args) {

        System.out.println("RETAIL ORDER DESK SYSTEM");

        ArrayList<Order> orders;

        try {

            orders = loadOrders();

            System.out.println("CSV Records Loaded: "
                    + orders.size());

        } catch (IOException e) {

            System.out.println("CSV file not found. "
                    + "Generating sample records.");

            orders = new ArrayList<>();
        }

        // Ensure 50000 records for search benchmark
        generateOrders(orders);

        System.out.println("Total Records Available: "
                + orders.size());

        // Execute all five tasks
        task1(orders);

        task2(orders);

        task3(orders);

        task4(orders);

        task5();

        System.out.println("\nALL TASKS COMPLETED SUCCESSFULLY");
    }
}
