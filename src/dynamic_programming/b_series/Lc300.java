package dynamic_programming.b_series;

import java.util.HashMap;
import java.util.Map;

public class Lc300 {
    public static void main (String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lis(nums));
    }


    public static int lis(int[] nums) {
        return lis(nums, 0, -1, new HashMap<>());
    }

    public static int lis(int[] nums, int index, int prevIndex, Map<String, Integer> memo) {
        String con = index + "|" + prevIndex;
        if(memo.containsKey(con)) {
            return memo.get(con);
        }

        if(index == nums.length) {
            return 0;
        }

        int leftAns = 0;
        int rightAns = 0;
        if(prevIndex == -1 || nums[prevIndex] < nums[index]) {
            leftAns = 1 + lis(nums, index + 1, index, memo);
        }
        rightAns = lis(nums, index+1, prevIndex, memo);

        int result = Math.max(leftAns, rightAns);

        memo.put(con, result);

        return result;
    }

}