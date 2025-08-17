package streams_prac;

import java.util.*;

public class Prac12 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,21,4,2);
        int sum = list.stream()
        .limit(5)
        .mapToInt(val->val)
        .sum();

        System.out.println(sum);

    }
}