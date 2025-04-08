package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem48 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1,1};
        int k = 2;

        System.out.println(sumToKay(nums, k));
    }

    public static int sumToKay(int[] nums, int k){
        Map<Integer, Integer> prefixSum =new HashMap<>();

        prefixSum.put(0, 1);
        int sum = 0;
        int countSum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(prefixSum.containsKey(sum - k)) {
//                countSum += prefixSum.get(sum - k);
                countSum++;
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return countSum;
    }
}
