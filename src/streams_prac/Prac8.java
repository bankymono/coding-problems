package streams_prac;

import java.util.*;

public class Prac8 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,4,11,40,120,80,2,3,400);
        long count = list.stream()
                    .filter(val -> val > 50)
                    .count();

        System.out.println(count);
    }
}