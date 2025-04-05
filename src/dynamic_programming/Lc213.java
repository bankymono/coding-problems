package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Lc213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,1,1}));
    }

    public static int rob(int[] nums) {
        return rob(nums, 0, new HashMap<>());
    }

    public static int rob(int[] nums, int index, Map<Integer, Integer> memo) {
        if(memo.containsKey(index)) return memo.get(index);
        if(index >= nums.length) {
            return 0;
        }

        int leftTree =  nums[index] + rob(nums, index + 2,memo);
        int rightTree = rob(nums, index + 1, memo);

        int result = Math.max(leftTree, rightTree);

        memo.put(index, result);
        return result;
    }

}
