package streams_prac;

import java.util.*;

public class Prac21 {
    public static void main(String[] args){
        List<String> word = Arrays.asList("apple", "banana", "mango");

        word = word.stream().map(String::toUpperCase).toList();

        // word.forEach(System.out::println);
        System.out.println(word);
    }
}