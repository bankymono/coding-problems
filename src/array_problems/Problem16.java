package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem16 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        System.out.println(subArrayDistinctK(nums, k));
    }

    public static int subArrayDistinctK(int[] nums, int k){
        return subArrayMostK(nums, k) - subArrayMostK(nums, k - 1);
    }

    public static int subArrayMostK(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);


            while(freqMap.size() > k){
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);

                if(freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            } 

            count += i - left + 1;
        }

        return count;
    }
}
