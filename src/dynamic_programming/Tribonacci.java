package dynamic_programming;

import java.util.HashMap;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(10));
    }

    public static int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> memo) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) {
            return 0;
        }

        if(n == 1 || n == 2) {
            return 1;
        }

        int result = tribonacci(n - 1, memo) + tribonacci(n - 2,memo) + tribonacci(n -3, memo);
        memo.put(n, result);

        return result;
    }
}
