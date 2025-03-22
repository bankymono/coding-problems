package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem43 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3}; 
        int k = 2;
        
        System.out.println(subArrWithKayDiff(nums, k));
    }

    public static int subArrWithKayDiff(int[] nums, int k) {
        return subArrMost(nums, k) - subArrMost(nums, k - 1);
    }

    public static int subArrMost(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        int left = 0;
        int count = 0;

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

            numFreq.put(currentNum, numFreq.getOrDefault(currentNum, 0)  + 1);

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
