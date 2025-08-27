package streams_prac;

import java.util.*;

public class Prac16 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6);

        int max = list.stream()
        .mapToInt(Integer::intValue)
        .max().orElseThrow();

        System.out.println(max);
    }
}