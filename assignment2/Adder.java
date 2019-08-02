package assignment2;
import java.util.Scanner;

public class Adder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a list of numbers: ");
        while (in.hasNext()) {
            String raw = in.nextLine();
            String[] filter = raw.replaceAll("\\s{2,}", " ").trim().split("\\s");
            System.out.println("Result is: " + adder(filter));
            System.out.println();
            System.out.print("Enter another list: ");
        }
    }

    public static int adder(String[] a) {
        int sum = 0;
        for (String x: a){
            int z = Integer.parseInt(x);
            sum+=z;
        }
        return sum;
    }
}