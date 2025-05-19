package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem66 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        int k = 2;

        System.out.println(sumToKay(nums, k));
    }

    public static int sumToKay(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();

        int count = 0;
        int sum = 0;
        numMap.put(0, 1);

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];
            sum += currentNum;
            if(numMap.containsKey(sum - k)){
                count += numMap.get(sum - k);
            }

            numMap.put(sum,numMap.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
