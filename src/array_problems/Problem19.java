package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem19 {
    private static Map<Integer, Integer> memo = new HashMap <>();
    public static void main(String[] args) {
        int input = 6;
        System.out.println(coinDeterminer(input));
    }

    public static int coinDeterminer(int num) {
        int[] coins = {1, 5, 7, 9, 11};
        if(num == 0) return 0;

        if(memo.containsKey(num)) return memo.get(num);

        int minCoins = Integer.MAX_VALUE;

        for(int coin : coins) {
            if(num - coin >= 0) {
                int result = coinDeterminer(num - coin) + 1;
                minCoins = Math.min(minCoins, result);
            }
        }

        memo.put(num, minCoins);

        return minCoins;
    }
}
