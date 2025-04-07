package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Lc213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1}));
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int case1 = robHelper(nums, 0, nums.length - 2, new HashMap<>());
        int case2 = robHelper(nums, 1, nums.length - 1, new HashMap<>());

        return Math.max(case1,case2);
    }


    public static int robHelper(int[] nums, int index, int end, Map<Integer, Integer> memo) {
        if(memo.containsKey(index)) return memo.get(index);
        if(index > end) {
            return 0;
        }

        int leftTree =  nums[index] + robHelper(nums, index + 2,end, memo);
        int rightTree = robHelper(nums, index + 1, end, memo);

        int result = Math.max(leftTree, rightTree);

        memo.put(index, result);
        return result;
    }

}
