import java.util.Stack;

public class ReverseStack {
    public static void main(String[]args){
        Stack<Integer>st=new Stack<>();
        int[]arr={1,2,3,4,5,6,7,8,9};
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=st.pop();
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
