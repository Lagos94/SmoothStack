package assignment3;

import java.io.*;
import java.util.*;

public class CharCounter {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a single letter to search for: ");
        while (input.hasNext()) {
            String rawEntry = input.next();
            char firstLetter = rawEntry.charAt(0);
            FileReader file = new FileReader("C:\\Users\\jose9\\Desktop\\Test.txt");
            Counter object = new Counter(file, firstLetter);
            System.out.println("The letter a appears " + object.count(object.readFile()) + " times.");
            System.out.println();
            System.out.print("Search for another letter: ");
        }
    }
}