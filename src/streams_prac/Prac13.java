package streams_prac;

import java.util.*;

public class Prac13{
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,4,3,6,6,1,24);
        int max = list.stream()
        .mapToInt(val -> val)
        .max().orElse(0);

        int min = list.stream()
        .mapToInt(val -> val)
        .min().orElse(0);

        System.out.println(max - min);
    }
}