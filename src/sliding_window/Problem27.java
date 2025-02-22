package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem27 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(sumArr(nums,k));
    }

    public static int sumArr(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int count = 0;
        int currentSum = 0;

        prefixSum.put(0,1);

        for(int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            if(prefixSum.containsKey(currentSum - k)) {
                count += prefixSum.get(currentSum - k);
            }

            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }


}
