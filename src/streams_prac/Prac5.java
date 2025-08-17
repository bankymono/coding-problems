package streams_prac;

import java.util.*;

public class Prac5 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,3,5,2,3,5,4,6,7,9,11);
        int sum = list.stream()
                    .filter(val -> val % 2 == 0)
                    .mapToInt(val -> val)
                    .sum();

        System.out.println(sum);
    }
}