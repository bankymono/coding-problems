package streams_prac;

import java.util.*;

public class Prac17 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,4,5,6,7);
        int min = list.stream()
                    .mapToInt(val->val)
                    .min()
                    .orElseThrow();

        System.out.println(min);
    }
}