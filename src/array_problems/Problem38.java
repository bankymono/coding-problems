package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem38 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(maxInWindow(nums,k));
    }

    public static List<Integer> maxInWindow(int[] nums, int k) {
        Map<Integer, Integer> windowMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < k; i++){
            windowMap.put(nums[i], windowMap.getOrDefault(nums[i], 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(int val : windowMap.keySet()) {
            max = Math.max(max, val);
        }

        result.add(max);

        for(int i = k; i < nums.length;i++){

            int outNum = nums[i - k];
            int currentNum = nums[i];

            windowMap.put(outNum, windowMap.get(outNum) - 1);
            if(windowMap.get(outNum) == 0) {
                windowMap.remove(outNum);
            }

            windowMap.put(currentNum, windowMap.getOrDefault(currentNum, 0) + 1);

            max = Integer.MIN_VALUE;
            for(int val : windowMap.keySet()) {
                max = Math.max(max, val);
            }

            result.add(max);
        }

        return result;
    }
}
