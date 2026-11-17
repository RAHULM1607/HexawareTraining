package Day1Assignment;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Task3DuplicateDetection {
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

    static void task3(ArrayList<Order> orders) {
        System.out.println("\n===== TASK 3: DUPLICATE DETECTION =====");

        HashMap<String, Order> map = new HashMap<>();
        int duplicateCount = 0;

        for (Order order : orders) {
            // Duplicate key uses customer, amount, and same minute.
            String key = order.customerId + "|"
                    + order.amount.stripTrailingZeros().toPlainString() + "|"
                    + order.createdAt.truncatedTo(ChronoUnit.MINUTES);

            if (map.containsKey(key)) {
                System.out.println("Duplicate Order Found:");
                System.out.println("Original: " + map.get(key));
                System.out.println("Duplicate: " + order);
                duplicateCount++;
            } else {
                map.put(key, order);
            }
        }

        System.out.println("Total Duplicate Orders: " + duplicateCount);
        System.out.println("Time Complexity: O(n) average");
        System.out.println("Space Complexity: O(n)");
    }

    public static void main(String[] args) {
        task3(getOrders());
    }
}
