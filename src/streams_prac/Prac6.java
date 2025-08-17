package streams_prac;

import java.util.*;


public class Prac6 {
    public static void main(String[] args){
        List<Integer> list = List.of(3,4,5,7,11,12,16,3,6);
        int sum = list.stream()
                .filter(val -> val % 2 != 0)
                    .mapToInt(val -> val)
                    .sum();

        System.out.println(sum);
    }
}