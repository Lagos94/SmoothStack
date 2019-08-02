package assignment2;
import java.util.Arrays;
import java.util.Scanner;

public class DoubleArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        while (in.hasNext()) {
            int entry = in.nextInt();
            int[][] array = new int[entry][entry];
            int max = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = (int) (100 * Math.random());
                    if (array[i][j] >= max) {
                        max = array[i][j];
                    }
                }
                System.out.println(Arrays.toString(array[i]));
            }
            System.err.println("The max value in this array is: " + max);
            System.out.println();
            System.out.print("Enter another array: ");
        }
    }
}