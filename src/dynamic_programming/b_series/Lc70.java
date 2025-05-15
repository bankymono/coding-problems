package dynamic_programming.b_series;

import java.util.HashMap;
import java.util.Map;

public class Lc70 {
    public static void main(String[] args) {
        System.out.println(climbingStairs(8 ));
    }

    public static int climbingStairs(int n) {
        return climbingStairs(n, new HashMap<>());
    }
    public static int climbingStairs(int n, Map<Integer, Integer> memo) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0 || n == 1) return 1;

        int result = climbingStairs(n - 1, memo) + climbingStairs(n - 2, memo);

        memo.put(n, result);

        return result;
    }
}
