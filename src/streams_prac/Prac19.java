package streams_prac;

import java.util.*;

public class Prac19 {
    public static void main(String[] args){
        List<Integer> list = List.of(3,4,5,2,7,22,54,63,12,8,9);
        long count = list.stream()
                .filter(val -> val % 2 == 0)
                .count();

        System.out.println(count);
    }
}