package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem71 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        System.out.println(subArrayKDistinct(nums, k));
    }

   public static int subArrayKDistinct(int[] nums, int k) {
    return subArrayMostKay(nums, k) - subArrayMostKay(nums, k - 1);
   }

   public static int subArrayMostKay(int[] nums, int k) {
    Map<Integer, Integer> numMap = new HashMap<>();
    int left = 0;
    int count = 0;

    for(int right = 0; right < nums.length; right++) {
        int currentNum = nums[right];

        numMap.put(currentNum, numMap.getOrDefault(currentNum, 0) + 1);

        while(numMap.size() > k) {
            int leftNum = nums[left];

            numMap.put(leftNum, numMap.get(leftNum) - 1);

            if(numMap.get(leftNum) == 0) {
                numMap.remove(leftNum);
            }

            left++;
        }

        count += right - left + 1;
    }

    return count;
   }
}
