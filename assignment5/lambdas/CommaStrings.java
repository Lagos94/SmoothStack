package assignment5.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommaStrings {
    public static void commaString(List<Integer> list){
        List<String> listOfInts = list
                .stream()
                .map(s -> s%2==0? "e"+s.toString():"o"+s.toString())
                .collect(Collectors.toList());
        System.out.println(listOfInts);
    }

    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        for(int i = 0; i<10; i++)
        testList.add(i);
        commaString(testList);
    }
}
