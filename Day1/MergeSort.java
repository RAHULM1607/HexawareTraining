/**import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("enter the elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        MergeSort.mergeSort(arr, 0, n - 1);
        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
public class MergeSort{
    public static void mergeSort(int[]arr,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }

    }
    public static void merge(int[]arr,int start,int mid,int end){
        int i=start,j=mid+1,k=start;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                arr[k]=arr[i];
                k++;
                i++
            }
            arr[k]=arr[j];
            k++;
            j++;
        }
    }
}
**/