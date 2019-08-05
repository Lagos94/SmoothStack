package assignment5.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class specifiedMethod {
    public static List<String> target(List<String> string){
        return string
                .stream()
                .filter(s -> s.length() == 3 && s.charAt(0) == 'a')
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ArrayList<String> sampleStrings = new ArrayList<>();
        sampleStrings.add("azir");
        sampleStrings.add("add");
        sampleStrings.add("args");
        sampleStrings.add("two");
        sampleStrings.add("a12");
        sampleStrings.add("aaa");
        System.out.println(target(sampleStrings));

    }
}
