package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem29 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        
        System.out.println(sumToKay(nums, k));
    }

    public static int sumToKay(int[] nums, int k){
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        int count = 0;
        int currentSum = 0;

        prefixSumMap.put(0, 1);

        for(int i = 0; i < nums.length;i++) {
            currentSum += nums[i];

            if(prefixSumMap.containsKey(currentSum - k)){
                count += prefixSumMap.get(currentSum - k);
            }

            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
