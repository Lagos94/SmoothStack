package assignment5.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class BasicLambdas {
    public static void main(String[] args) {
        String[] stringList = {"fruit", "e", "eek", "tzar", "actor", "good", "armageddon", "evolve"};

        Arrays.sort(stringList, Comparator.comparingInt(String::length));
        String[] ascendList = stringList.clone();
        printArray(ascendList);

        Arrays.sort(stringList, (s1,s2) -> s2.length()-s1.length());
        String[] descendList = stringList.clone();
        printArray(descendList);

        Arrays.sort(stringList, Comparator.comparingInt(s -> s.charAt(0)));
        String[] firstLetterList = stringList.clone();
        printArray(firstLetterList);

        Arrays.sort(stringList, Comparator.comparing(s -> s.charAt(0)!='e'));
        String[] containEFirst = stringList.clone();
        printArray(containEFirst);
    }

    static void printArray(String[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
