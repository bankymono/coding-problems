package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem14 {
    public static void main(String[] args) {
         int[] nums = {1, 1, 1}; 
         int k = 2;
        System.out.println(String.format("array count is %s", countTheArr(nums, k)));

    }

    public static int countTheArr(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        prefixSumMap.put(0,1);

        for (int num : nums){
            sum += num;

            if(prefixSumMap.containsKey(sum - k)){
                count++;
            }

            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) +1);
        }
        return count;
    }
}
