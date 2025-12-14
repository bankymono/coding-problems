package streams_prac;

import java.util.*;

public class Prac20 {
    public static void main(String ... args) {
        List<Integer> numbers  = Arrays.asList(1,2,3,4,5,6);

        List<Integer> evenNumbers = numbers.stream().filter(even -> even % 2 == 0).toList();

        evenNumbers.forEach(val -> System.out.println("num -> " + val));
    }
}