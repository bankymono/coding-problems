package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class NSteps {
    public static void main(String[] args) {
        System.out.println(nSteps(5));
    }

    public static int nSteps(int n) {
        return  nSteps(n, new HashMap<>());
    }

    public static int nSteps(int n, Map<Integer, Integer> memo) {
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        int totalSteps = nSteps(n - 1, memo) + nSteps(n - 2, memo) + nSteps(n - 3, memo);

        memo.put(n, totalSteps);

        return totalSteps;
    }

}
