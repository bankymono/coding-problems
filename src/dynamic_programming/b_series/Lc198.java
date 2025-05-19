package dynamic_programming.b_series;


import java.util.HashMap;
import java.util.Map;

public class Lc198 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(houseRobber(nums));
    }

    public static int houseRobber(int[] nums) {
        return houseRobber(0, nums, new HashMap<>());
    }

    public static int houseRobber(int index, int[] nums, Map<Integer, Integer> memo) {
        if(memo.containsKey(index)) return memo.get(index);
        if(index >= nums.length) {
            return 0;
        }

        int selected = nums[index] + houseRobber(index + 2, nums, memo);
        int unSelected = houseRobber(index + 1, nums, memo);

        int result = Math.max(selected, unSelected);

        memo.put(index, result);

        return result;
    }
}
