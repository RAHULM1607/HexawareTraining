package Day2Assignment;

import java.util.Arrays;

public class Task5TwoPointers {
    static int[] mergeSortedLists(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare elements from both arrays.
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < m) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] office1 = {10, 20, 40, 60};
        int[] office2 = {15, 25, 35, 50};

        int[] merged = mergeSortedLists(office1, office2);
        System.out.println("Merged sorted list: " + Arrays.toString(merged));

        System.out.println("Empty merge: "
                + Arrays.toString(mergeSortedLists(new int[]{}, new int[]{})));
    }
}
