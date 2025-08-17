package streams_prac;

import java.util.*;

public class Prac11 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,23,4,5,6,8,4,2,7);
        int sum = list.stream()
        .skip(3)
        .reduce(0, (acc, val) -> acc + val);
        System.out.println(sum);
    }
}