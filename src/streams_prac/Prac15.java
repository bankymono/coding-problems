package streams_prac;

import java.util.*;

public class Prac15 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6);
        int sum = list.stream()
        .mapToInt(val -> val)
        .sum();

        System.out.println(sum);
    }
}