package streams_prac;

import java.util.*;

public class Prac14 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,4,6,32,5,2,6);

        int sum = list.stream()
        .filter(val -> val > 0)
        .mapToInt(val->val)
        .sum();

        System.out.println(sum);
    }
}