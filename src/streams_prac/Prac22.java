package streams_prac;

import java.util.*;

public class Prac22 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        Optional<String> foundWord = names.stream().filter(item -> item.startsWith("A")).findFirst();

        foundWord.ifPresent(System.out::println);
    }
}