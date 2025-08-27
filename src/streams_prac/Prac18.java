package streams_prac;

import java.util.*;

public class Prac18 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,2,5);
        double avg = list.stream()
                        .mapToInt(val -> val)
                .average()
                        .orElseThrow();

        System.out.println(avg);
    }
}
