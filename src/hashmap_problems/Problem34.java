package hashmap_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem34 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(String.format("%s,  result -> %s", Arrays.toString(nums), noOfSubArrays(nums, k)));
    }

    public static int noOfSubArrays(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;
        int sum = 0;

        prefixSumMap.put(0,1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }

            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
