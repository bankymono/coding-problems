package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class SummingSquares {
    public static void main(String[] args) {
        System.out.println(summingSquares(12));
    }

    public static int summingSquares(int n) {
        return summingSquares(n, new HashMap<>());
    }

    public static int summingSquares(int n, Map<Integer, Integer> memo) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= Math.sqrt(n); i++) {
            int square = i * i;
            min = Math.min(summingSquares(n - square),min);
        }
        int result = min + 1;
        memo.put(n, result);
        return result;
    }
}
