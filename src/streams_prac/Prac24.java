package streams_prac;

import java.util.*;

public class Prac24 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana","mango");
        words.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}