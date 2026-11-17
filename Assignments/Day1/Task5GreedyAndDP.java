package Day1Assignment;
import java.util.Arrays;

public class Task5GreedyAndDP {
    static int greedyCoins(int[] coins, int amount) {
        int count = 0;
        Arrays.sort(coins);

        for (int i = coins.length - 1; i >= 0; i--) {
            int number = amount / coins[i];
            count += number;
            amount = amount % coins[i];
        }

        if (amount != 0) return -1;
        return count;
    }

    static int dpCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] > amount) return -1;
        return dp[amount];
    }

    static void task5() {
        System.out.println("===== TASK 5: GREEDY AND DP =====");

        int[] normalCoins = {1, 5, 10, 25};
        int refund = 63;

        System.out.println("Refund Amount: " + refund);
        System.out.println("Greedy Result: " + greedyCoins(normalCoins, refund));
        System.out.println("DP Result: " + dpCoins(normalCoins, refund));

        int[] specialCoins = {1, 3, 4};
        int amount = 6;

        System.out.println("\nGreedy Failure Example");
        System.out.println("Coin Denominations: " + Arrays.toString(specialCoins));
        System.out.println("Amount: " + amount);
        System.out.println("Greedy Result: " + greedyCoins(specialCoins, amount));
        System.out.println("DP Result: " + dpCoins(specialCoins, amount));

        System.out.println("\nGreedy Complexity: O(n log n)");
        System.out.println("DP Complexity: O(amount * n)");
        System.out.println("DP Space Complexity: O(amount)");
    }

    public static void main(String[] args) {
        task5();
    }

}
