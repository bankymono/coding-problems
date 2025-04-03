package dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingChange2 {
    public static void main(String[] args) {
        System.out.println(countingChange2(4, List.of(1, 2, 3)));
    }

    public static int countingChange2(int amount, List<Integer> coins) {
        return countingChange2(amount, 0, coins, new HashMap<>());
    }

    public static int countingChange2(int amount, int coinIdx, List<Integer> coins, Map<String, Integer> memo) {
        StringBuilder builder = new StringBuilder();
        builder.append(amount).append(",").append(coinIdx);
        if(memo.containsKey(builder.toString())) return memo.get(builder.toString());
        if(amount == 0) {
            return 1;
        }

        if(coinIdx >= coins.size()) {
            return  0;
        }

        int value = coins.get(coinIdx);
        int count = 0;
        for(int qty = 0; qty * value <= amount; qty += 1) {
            int subamount =amount - (qty * value);
            count += countingChange2(subamount, coinIdx + 1, coins, memo);
        }

        memo.put(builder.toString(), count);
        return count;
    }
}
