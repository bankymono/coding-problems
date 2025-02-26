package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem32 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;

        System.out.println(longestKDistinctArr(nums,k));
    }


    public static int longestKDistinctArr(int[] nums, int k){
        return longestMostKArr(nums, k) - longestMostKArr(nums, k - 1);
    }

    public static int longestMostKArr(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
        int arrCount = 0;
        Map<Integer,Integer> numMap = new HashMap<>();

        for(int right = 0; right < nums.length; right++) {
            numMap.put(nums[right], numMap.getOrDefault(nums[right], 0) + 1);

            while(numMap.size() > k) {
                int leftNum = nums[left];
                numMap.put(leftNum, numMap.get(leftNum) - 1);
                if(numMap.get(leftNum) == 0) {
                    numMap.remove(leftNum);
                }
                left++;
            }

            arrCount += (right - left + 1);
        }

        return arrCount;
    }
}
