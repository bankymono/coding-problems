package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem32 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 11;

        System.out.println(longestArrSumK(nums, k));
    }

    public static int longestArrSumK(int[] nums, int k){
        Map<Integer, Integer> numMap = new HashMap<>();

        int left = 0;
        int maxSum = 0;
        int maxLength = 0;
        int sum = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum > k) {
                int leftNum = nums[left];

                sum -= leftNum;

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
