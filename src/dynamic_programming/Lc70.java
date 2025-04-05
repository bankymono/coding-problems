package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Lc70 {
    public static void main(String[] args) {
        System.out.println(climbingSteps(3));
    }

    public static int climbingSteps(int n) {
        if(n <= 0 || n > 45) {
            return 0;
        }

        return climbingSteps(n, new HashMap<>());
    }

    public static int climbingSteps(int n, Map<Integer, Integer> memo) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) {
            return 1;
        }

        if(n < -1) {
            return 0;
        }

        int result = climbingSteps(n - 1, memo) + climbingSteps(n - 2, memo);

        memo.put(n, result);

        return result;
    }

}
