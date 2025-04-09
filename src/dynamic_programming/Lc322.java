package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Lc322 {
    public static void main(String[] args) {
        int[] coins = {1,2147483647};
//        System.out.println("sss" + Math.pow(2,31));
        System.out.println(coinChange(coins, 2));
    }

    public static int coinChange(int[] coins, int amount) {
        if(coins.length > 12) {
            return - 1;
        }

        return _coinChange(coins, amount, new HashMap<>());
    }

    public static int _coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if(memo.containsKey(amount)) return memo.get(amount);
        if(amount == 0) {
            return 0;
        }

        if(amount < 0) {
            return -1;
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if(coins[i] < 1) {
                return -1;
            }
            int result = _coinChange(coins, amount - coins[i], memo);
            if(result >= 0) {
                minCount = Math.min(result, minCount);
            }
        }
        int ans = minCount == Integer.MAX_VALUE ? -1 : minCount + 1;

        memo.put(amount, ans);
        return ans;
    }
}
