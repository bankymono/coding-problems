package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem12 {
    public static void main(String[] args) {
        int[] nums = {1, -1, 1, 1};
        int k = 2;

        System.out.println(sumToK(nums, k));
    }

    public static int sumToK(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        prefixSumMap.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }

            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
