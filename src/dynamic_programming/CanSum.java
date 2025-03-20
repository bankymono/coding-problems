package dynamic_programming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CanSum {
    private static final Map<Integer, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{5, 3, 4, 8}));
    }

    public static boolean canSum(int targetSum, int[] nums) {
        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }

        if(targetSum == 0) {
            return true;
        }

        if(targetSum < 0)
            return false;

        for (int num : nums) {
            memo.put(targetSum,canSum(targetSum - num, nums));
        }

        return  memo.get(targetSum);
    }
}
