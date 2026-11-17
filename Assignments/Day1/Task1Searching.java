package Day1Assignment;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Task1Searching {
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

    // Linear Search: checks each order one by one.
    static Order linearSearch(ArrayList<Order> orders, int targetId) {
        for (Order order : orders) {
            if (order.orderId == targetId) return order;
        }
        return null;
    }

    // Binary Search: works only when the list is sorted by orderId.
    static Order binarySearch(ArrayList<Order> orders, int targetId) {
        int left = 0;
        int right = orders.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (orders.get(mid).orderId == targetId) {
                return orders.get(mid);
            } else if (orders.get(mid).orderId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    static void task1(ArrayList<Order> orders) {
        System.out.println("\\n===== TASK 1: SEARCHING =====");
        int targetId = orders.get(orders.size() - 1).orderId;

        ArrayList<Order> sortedOrders = new ArrayList<>(orders);
        sortedOrders.sort(Comparator.comparingInt(o -> o.orderId));

        long start = System.nanoTime();
        Order result1 = null;
        for (int i = 0; i < 1000; i++) {
            result1 = linearSearch(orders, targetId);
        }
        long linearTime = System.nanoTime() - start;

        start = System.nanoTime();
        Order result2 = null;
        for (int i = 0; i < 1000; i++) {
            result2 = binarySearch(sortedOrders, targetId);
        }
        long binaryTime = System.nanoTime() - start;

        System.out.println("Target Order ID: " + targetId);
        System.out.println("Linear Search Result: " + result1);
        System.out.println("Binary Search Result: " + result2);
        System.out.println("Linear Search (1000 runs): " + linearTime + " ns");
        System.out.println("Binary Search (1000 runs): " + binaryTime + " ns");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n)");
        System.out.println("Note: Binary search requires sorted data.");
    }

    public static void main(String[] args) {
        task1(getOrders());
    }
}
