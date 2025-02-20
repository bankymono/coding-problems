package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
    }

    public static long fib(int n) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        if(n <= 2) return 1;
        long ans = fib(n - 1) + fib(n - 2);
        memo.put(n, ans);

        return ans;
    }
}
