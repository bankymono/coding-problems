package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem54 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(maxInSubArrays(nums, k));        
    }

    public static List<Integer> maxInSubArrays(int[] nums, int k) {
        Map<Integer,Integer> windowMap = new HashMap<>();

       int maxValue = Integer.MIN_VALUE;
       List<Integer> result = new ArrayList<>();

        for(int i = 0; i < k; i++){
            windowMap.put(nums[i], windowMap.getOrDefault(nums[i], 0) + 1);
            maxValue = Math.max(nums[i], maxValue);
        }

        result.add(maxValue);


        for(int i = k; i < nums.length; i++) {
            windowMap.put(nums[i], windowMap.getOrDefault(nums[i], 0) + 1);
            int outNum = nums[i - k];
            windowMap.put(outNum, windowMap.get(outNum) - 1);
            if(windowMap.get(outNum) == 0) {
                windowMap.remove(outNum);
            }
            maxValue = 0;
            for(Map.Entry<Integer, Integer> item : windowMap.entrySet()) {
                maxValue = Math.max(item.getKey(), maxValue);
            }


            result.add(maxValue);
        }

        return result;
    }
}
