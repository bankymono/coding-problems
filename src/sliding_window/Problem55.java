package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem55 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;

        System.out.println(subArrDiffKay(nums, k));        
    }

    public static int subArrDiffKay(int[] nums, int k) {
      return subArrMostKay(nums, k) - subArrMostKay(nums, k - 1);
    }

    public static int subArrMostKay(int[] nums, int k) {
        int left = 0;
        int count = 0;
        Map<Integer, Integer> charMap = new HashMap<>();

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];
            charMap.put(currentNum, charMap.getOrDefault(currentNum, 0) + 1);

            while(charMap.size() > k) {
                int leftNum = nums[left];

                charMap.put(leftNum, charMap.get(leftNum) - 1);

                if(charMap.get(leftNum) == 0) {
                    charMap.remove(leftNum);
                }

                left++;
            }

            count += right - left;
        }

        return count;
    }
}

