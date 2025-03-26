package dynamic_programming;

import java.util.*;

public class MinChange {
    public static void main(String[] args) {
        System.out.println(minChange(5, new int[]{1, 2, 3}));
        System.out.println(minChange(4, new int[]{1, 2, 3, 4}));
        System.out.println(minChange(15, new int[]{7, 7, 7}));
    }

    public static int minChange(int amount, int[] coins) {
        return minChange(amount, coins, new HashMap<>());
    }

    public static int minChange(int amount, int[] coins, HashMap<Integer, Integer> memo) {
        if(memo.containsKey(amount)) return memo.get(amount);

        if(amount == 0) {
            return 0;
        }

        if(amount < 0) {
            return -1;
        }

        int result;
        int minSize = Integer.MAX_VALUE;

        for(int coin : coins) {
            int subAmount = amount - coin;
            int prevResult = minChange(subAmount, coins);

            if(prevResult != -1) {
                prevResult++;
                minSize = Math.min(prevResult, minSize);
            }
        }


        result = minSize == Integer.MAX_VALUE ? -1 : minSize;

        memo.put(amount, result);
        return  result;
    }
}
