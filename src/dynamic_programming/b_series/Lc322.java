package dynamic_programming.b_series;


import java.util.HashMap;
import java.util.Map;

public class Lc322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new HashMap<>());
    }

    public static int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if(memo.containsKey(amount)) return memo.get(amount);

        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return  -1;
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int count = coinChange(coins, amount - coins[i], memo);
            if(count >= 0) {
                minCount = Math.min(count, minCount);
            }
        }

        minCount = minCount == Integer.MAX_VALUE ? -1 : minCount + 1;
        memo.put(amount, minCount);

        return minCount;
    }
}
