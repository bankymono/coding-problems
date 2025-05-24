package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem69 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutiveSeq(nums));
    }

    public static int longestConsecutiveSeq(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        int longest = Integer.MIN_VALUE;

        for(int num : nums) {
            if(!numMap.containsKey(num)) {
                int left = numMap.getOrDefault(num - 1, 0);
                int right = numMap.getOrDefault(num + 1, 0);

                int currentStreak = left + right + 1;

                longest = Math.max(longest, currentStreak);

                numMap.put(num - left, currentStreak);
                numMap.put(num + right, currentStreak);
                numMap.put(num, currentStreak);
            }
        }

        return longest;
    }
}
