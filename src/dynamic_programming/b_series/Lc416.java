package dynamic_programming.b_series;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Lc416 {
    public static void main(String[] args) {
//        int[] nums = {1,5,11,5};
        int[] nums = {1,2,3,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) {
            return false;
        }

        int avg = sum /2;

        return canPartition(nums, avg, 0, new HashMap<>());
    }

    public static boolean canPartition(int[] nums, int total, int index, Map<String, Boolean> memo) {
        String key = total + "|" + index;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(total == 0) {
            return true;
        }

        if(index >= nums.length || total < 0) {
            return false;
        }

        boolean selected = canPartition(nums, total - nums[index], index + 1, memo);
        boolean notSelected = canPartition(nums, total, index + 1, memo);

        boolean result;
        if(selected) {
            result = selected;
        } else {
            result = notSelected;
        }
        memo.put(key, result);

        return result;
    }
}
