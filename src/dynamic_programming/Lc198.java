package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Lc198 {
    public static void main(String[] args) {
        System.out.println(houseRobber(new int[]{1}));
    }

    public static int houseRobber(int[] nums) {
        if(nums.length > 100 || nums.length < 1) {
            return 0;
        }
        return rob(nums, 0, new HashMap<>());
    }

    public static int rob(int[] nums, int index, Map<Integer, Integer> memo) {
        if(memo.containsKey(index)) {
            memo.get(index);
        }

        if(index >= nums.length) {
            return  0;
        }

        if(nums[index] > 400 || nums[index] < 0) return 0;

        int leftTree = nums[index] + rob(nums, index + 2, memo);
        int rightTree = rob(nums,  index + 1, memo);

        int result = Math.max(leftTree, rightTree);

        memo.put(index, result);

        return result;
    }
}
