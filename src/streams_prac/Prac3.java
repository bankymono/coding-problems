package streams_prac;

import java.util.*;

public class Prac3 {
    public static void main(String[] args) {
        List<Integer> list = List.of(2,3,6,13,7,8);
        int maxVal = list.stream()
        .mapToInt(val -> val)
                .max()
            .getAsInt();

            System.out.println(maxVal);

    }
}