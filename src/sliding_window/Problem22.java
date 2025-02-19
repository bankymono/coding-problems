package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem22 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subArrSum(nums, k));
    }

    public static int subArrSum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int count = 0;
        prefixSum.put(0, 1);

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            if(prefixSum.containsKey(sum - k)) {
                count++;
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
