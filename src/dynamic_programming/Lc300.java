package dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums){
        return lengthOfLIS(nums, 0, -1, new HashMap<>());
    }

    public static int lengthOfLIS(int[] nums, int currentIndex, int prevIndex, Map<String, Integer> memo){
        StringBuilder key = new StringBuilder();
        key.append(currentIndex).append(",").append(prevIndex);
        if(memo.containsKey(key.toString())) return memo.get(key.toString());
        if(currentIndex == nums.length) {
            return 0;
        }


        int take = 0;
        if(prevIndex == -1 || nums[currentIndex] > nums[prevIndex]) {
            take = 1 + lengthOfLIS(nums, currentIndex + 1, currentIndex, memo);
        }

        int skip = lengthOfLIS(nums, currentIndex + 1, prevIndex, memo);

        int result = Math.max(skip, take);

        memo.put(key.toString(), result);

        return  result;
    }
}
