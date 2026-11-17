package Day2Assignment;

public class Task4SlidingWindow {
    static int longestRun(int[] dailyClaims) {
        int maxLength = 0;
        int currentLength = 0;

        for (int count : dailyClaims) {
            if (count > 100) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] dailyClaims = {120, 150, 130, 90, 110, 140, 160, 170, 80};

        System.out.println("Longest consecutive days above 100: "
                + longestRun(dailyClaims));
        System.out.println("Empty sliding window: " + longestRun(new int[]{}));
    }
}
