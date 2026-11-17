package Day1Assignment;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Task2Sorting {
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


    static void bubbleSort(ArrayList<Order> orders) {
        int n = orders.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders.get(j).amount.compareTo(orders.get(j + 1).amount) < 0) {
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                }
            }
        }
    }

    static void mergeSort(ArrayList<Order> orders) {
        if (orders.size() <= 1) return;

        int mid = orders.size() / 2;
        ArrayList<Order> left = new ArrayList<>(orders.subList(0, mid));
        ArrayList<Order> right = new ArrayList<>(orders.subList(mid, orders.size()));

        mergeSort(left);
        mergeSort(right);
        merge(orders, left, right);
    }

    static void merge(ArrayList<Order> orders, ArrayList<Order> left, ArrayList<Order> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).amount.compareTo(right.get(j).amount) >= 0) {
                orders.set(k++, left.get(i++));
            } else {
                orders.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) orders.set(k++, left.get(i++));
        while (j < right.size()) orders.set(k++, right.get(j++));
    }

    static void task2(ArrayList<Order> orders) {
        System.out.println("\n===== TASK 2: SORTING =====");

        // Use first 10,000 records for sorting comparison.
        ArrayList<Order> original = new ArrayList<>(orders.subList(0, 10000));
        ArrayList<Order> bubble = new ArrayList<>(original);
        ArrayList<Order> merge = new ArrayList<>(original);
        ArrayList<Order> builtIn = new ArrayList<>(original);

        long start = System.nanoTime();
        bubbleSort(bubble);
        long bubbleTime = System.nanoTime() - start;

        start = System.nanoTime();
        mergeSort(merge);
        long mergeTime = System.nanoTime() - start;

        start = System.nanoTime();
        builtIn.sort((a, b) -> b.amount.compareTo(a.amount));
        long builtInTime = System.nanoTime() - start;

        System.out.println("Records Sorted: 10000");
        System.out.println("Bubble Sort Time: " + bubbleTime + " ns");
        System.out.println("Merge Sort Time: " + mergeTime + " ns");
        System.out.println("Built-in Sort Time: " + builtInTime + " ns");

        System.out.println("\nTop 5 Orders by Amount:");
        for (int i = 0; i < 5; i++) System.out.println(builtIn.get(i));

        System.out.println("\nBubble Sort: O(n^2)");
        System.out.println("Merge Sort: O(n log n)");
        System.out.println("Built-in TimSort: O(n log n) worst case");

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
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        task2(getOrders());
    }
}
