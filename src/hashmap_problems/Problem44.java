package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem44 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(consecutiveNums(nums));
    }

    public static int consecutiveNums(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        int longestStreak = 0;

        for(int num : nums) {
            if(!numMap.containsKey(num)) {
                int left = numMap.getOrDefault(num - 1, 0);
                int right = numMap.getOrDefault(num + 1, 0);

                int currentStreak = left + right + 1;

                longestStreak = Math.max(currentStreak, longestStreak);


                numMap.put(num, currentStreak);
                numMap.put(num - left, currentStreak);
                numMap.put(num + right, currentStreak);
            }
        }

        return longestStreak;
    }
}
