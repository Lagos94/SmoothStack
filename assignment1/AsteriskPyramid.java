package assignment1;
import java.util.Scanner;

public class AsteriskPyramid {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int r = in.nextInt();
            pyramidPattern(r);
            System.out.print("enter another number: ");
        }
    }

    public static void pyramidPattern(int value) {
        if (value == 0) return;
        for (int x = 0; x < value; x++) {
            for (int y = x; y >= 0; y--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        for (int x = 0; x < value; x++) {
            for (int y = 0; y < value - x; y++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        for (int x = 0; x < value; x++) {
            for (int y = 0; y < (value - x-1); y++) {
                System.out.print(" ");
            }
            for (int z = 0; z<=x; z++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        for (int x = 0; x < value; x++) {
            for (int y = 0; y < (value - x-1); y++) {
                System.out.print("  ");
            }
            for (int z = 0; z<=x; z++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        for (int x = 0; x < value; x++) {
            for (int y = x; y > 0; y--) {
                System.out.print(" ");
            }
            for (int z = 0; z<value-x; z++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        for (int x = 0; x < value; x++) {
            for (int y = x; y > 0; y--) {
                System.out.print("  ");
            }
            for (int z = 0; z<value-x; z++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}