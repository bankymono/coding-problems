package dynamic_programming.b_series;

import java.util.HashMap;
import java.util.Map;

public class Lc213 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(houseRobber(nums));
    }


    public static int houseRobber(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int result1 = houseRobber(nums, 0, nums.length - 2, new HashMap<>());
        int result2 = houseRobber(nums, 1, nums.length - 1, new HashMap<>());

        return Math.max(result1,result2);
    }

    public static int houseRobber(int[] nums, int startIndex, int end, Map<Integer,Integer> memo) {
        if(memo.containsKey(startIndex)) {
            return memo.get(startIndex);
        }

        if(startIndex > end) {
            return 0;
        }


        int selected = nums[startIndex] +  houseRobber(nums, startIndex + 2, end,memo);
        int unselected = houseRobber(nums, startIndex + 1, end,memo);

        int max = Math.max(selected, unselected);

        memo.put(startIndex, max);

        return max;
    }




}
