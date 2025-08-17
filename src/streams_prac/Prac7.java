package streams_prac;

import java.util.*;

public class Prac7 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        long prod = list.stream()
                .reduce(1, (acc, val) -> acc * val);

                System.out.println(prod);
    }
}