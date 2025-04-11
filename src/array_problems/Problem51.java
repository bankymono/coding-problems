package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem51 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestRepeating(nums));
    }

    public static int longestRepeating(int[] nums) {
        Map<Integer, Integer> keyMap = new HashMap<>();
        int longest = 0;

        for(int i = 0; i < nums.length; i++){
            int currentNum = nums[i];

            if(!keyMap.containsKey(currentNum)) {
                int left = keyMap.getOrDefault(currentNum - 1, 0);
                int right = keyMap.getOrDefault(currentNum + 1, 0);

                int currentSize = left + right + 1;

                longest = Math.max(currentSize, longest);


                keyMap.put(currentNum - left, currentSize);
                keyMap.put(currentNum + right, currentSize);
                keyMap.put(currentNum, currentSize);
            }
        }

        return longest;
    }
}
