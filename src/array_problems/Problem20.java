package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem20 {
    public static void main(String[] args) {
        int num = 6;
        System.out.println(coinDeterminer(num));
    }

    private static Map<Integer, Integer> memo = new HashMap<>();


    public static int coinDeterminer(int num) {
        int[] coins = {1, 5, 7, 9, 11}; 
        int least = Integer.MAX_VALUE;

        if(memo.containsKey(num)) {
            return memo.get(num);
        }

        if(num == 0) return 0;

        for(int coin : coins ) {
            if(num - coin >= 0){
                int result = coinDeterminer(num - coin) + 1;
                least = Math.min(result, least);
            }
        }

        memo.put(num, least);

        return least;
    }
}
