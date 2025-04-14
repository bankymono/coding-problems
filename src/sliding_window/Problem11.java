package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem11 {
    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveNum(num));
    }

    public static int longestConsecutiveNum(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int longestStreak =  0;

        for(int i = 0; i < nums.length; i++) {

            if(!numMap.containsKey(nums[i])) {
                int left = numMap.getOrDefault(nums[i] - 1, 0);
                int right = numMap.getOrDefault(nums[i] + 1, 0);

                int currentStreak = left + right + 1;

                longestStreak = Math.max(currentStreak, longestStreak);


                numMap.put(nums[i] - left, currentStreak);
                numMap.put(nums[i], currentStreak);
                numMap.put(nums[i] + right, currentStreak);
            }
        }

        return longestStreak;
    }
}
