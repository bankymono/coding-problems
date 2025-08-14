package streams_prac;

import java.util.*;

public class Prac2 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4);

        double average = list.stream()
        .mapToInt(val->val)
                .average().orElse(0);

        System.out.println(average);
    }
}