package streams_prac;

import java.util.*;

public class Prac10 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,3,45,6,2,6,7,8);
        int sum = list.stream()
        .distinct()
        .mapToInt(val->val)
        .sum();

        System.out.println(sum);
    }
}