import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size:");
        int n = sc.nextInt();

        int a[] = new int[100];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        SelectionSort.selectionSort(a, n);

        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}