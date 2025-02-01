package hashmap_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem49 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumFunction(nums, target)));
    }

    public static int[] twoSumFunction(int[] nums, int target) {
        Map<Integer, Integer> numFreq = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];

            if(numFreq.containsKey(compliment)) {
                return new int[]{numFreq.get(compliment), i};
            }

            numFreq.put(nums[i], i);
        }

        return new int[] {-1,-1};
    }
}
