package dynamic_programming.b_series;

import java.util.Map;
import java.util.HashMap;

public class Lc309 {
    public static void main(String[] args) {
//        int[] prices = {1,2,3,0,2};
        int[] prices = {1};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if(prices == null) {
            return 0;
        }
        return maxProfit(prices, 0, true, new HashMap<>());
    }

    public static int maxProfit(int[] prices, int index, boolean canBuy, Map<String, Integer> memo) {
        String key = index + "|" + canBuy;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(index >= prices.length) {
            return 0;
        }
        int max  = 0;

        if(canBuy) {
            int  get = -prices[index] + maxProfit(prices, index + 1, false, memo);
            int skip = maxProfit(prices, index + 1, true, memo);
            max = Math.max(get,skip);
        } else {
            int get = prices[index] + maxProfit(prices, index + 2, true, memo);
            int skip = maxProfit(prices, index + 1, false, memo);
            max = Math.max(get,skip);
        }

        memo.put(key, max);

        return max;
    }
}
