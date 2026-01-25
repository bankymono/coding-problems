package streams_prac;

import java.util.*;

public class Prac25 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("blice", "John", "Bob");

        String name = names.stream().filter(val -> val.startsWith("A")).findFirst().orElse(null);

        System.out.println(name);
    }
}