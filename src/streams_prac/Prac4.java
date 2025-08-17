package streams_prac;

import java.util.*;

public class Prac4 {
    public static void main(String[] args) {
        List<Integer> list = List.of(3,2,6,4,7,5);
        int min = list.stream()
                    .mapToInt(val -> val)
                    .min()
                    .getAsInt();

            System.out.println(min);
    }
}