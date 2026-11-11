import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        String str=" my name is asha";
        List<String> list=new ArrayList<>();
        Stack<Character> stack=new Stack<>();
        for(String word:str.split(" ")) {

            list.add(word);
        }
        for(String word:list){
            for(int i=0;i<word.length();i++) {
                stack.push(word.charAt(i));

            }
            while(!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
            System.out.print(" ");



        }

    }
}
