import java.util.ArrayList;

public class Test2 {

    static int capacity = 4;
    static ArrayList<String> enrolled = new ArrayList<>();


    public static String enroll(String name) {

        if (enrolled.size() < capacity) {
            enrolled.add(name);
            return "enrolled";
        }

        return "batch full";
    }


    public static void drop(String name) {
        enrolled.remove(name);
    }

    public static void main(String[] args) {

        String[] names = {"Anu", "Ravi", "Meena", "John", "Sara"};


        for (String name : names) {
            System.out.println(name + " " + enroll(name));
        }


        drop("Ravi");


        System.out.println("Enrolled: " + enrolled);


        System.out.println("Seat 1: " + enrolled.get(0));
    }
}