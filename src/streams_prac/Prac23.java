package streams_prac;

import java.util.*;

public class Prac23 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> even = numbers.stream().filter(num -> num % 2 == 0).toList();

        even.forEach(System.out::println);
    }
}