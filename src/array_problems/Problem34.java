package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem34 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarrayDistinctKay(nums, k));
    }

    public static int subarrayDistinctKay(int[] nums, int k) {
        return subArrayMostKay(nums, k) - subArrayMostKay(nums, k - 1);
    }

    public static int subArrayMostKay(int[] nums, int k){
        Map<Integer, Integer> numFreq = new HashMap<>();

        int left = 0;
        int count = 0;

        for(int right = 0; right < nums.length; right++) {

            int currentNUm = nums[right];

            numFreq.put(currentNUm, numFreq.getOrDefault(currentNUm, 0) + 1);

            while(numFreq.size() > k) {
                int leftNum = nums[left];

                numFreq.put(leftNum, numFreq.get(leftNum) - 1);
                
                if(numFreq.get(leftNum) == 0) {
                    numFreq.remove(leftNum);
                }

                left++;
            }
            count += right - left + 1;
        }

        return count;
    }
}
