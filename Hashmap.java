package Day2;




import java.util.*;
public class Hashmap
{
    public static void main(String[] args) {
        String str = "HELLOWORLD";
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char key:map.keySet()){
            System.out.println(key+"--"+map.get(key));
        }
    }
}