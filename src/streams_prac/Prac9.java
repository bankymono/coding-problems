package streams_prac;

import java.util.*;

public class Prac9 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6,7);
        long sum = list.stream()
        .map(val -> val * val)
        .mapToLong(val -> val)
        .sum();

        System.out.println(sum);
    }
}