package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem64 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 1, 4};
        int k = 3;

        System.out.println(maxInArray(nums, k));
    }

    public static List<Integer> maxInArray(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();

        int max = Integer.MIN_VALUE;


        for(int i = 0; i < k; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
            max = Math.max(nums[i], max);
        }

        result.add(max);

        for(int i = 1; i < n; i++) {
            int outNum = nums[(i - 1)%n];
            int currentNum = nums[(i + k - 1)%n];
            
            numMap.put(outNum, numMap.get(outNum) - 1);
            if(numMap.get(outNum) == 0) {
                numMap.remove(outNum);
            }

            numMap.put(currentNum, numMap.getOrDefault(currentNum, 0) + 1);

            max=Integer.MIN_VALUE;
            for(Map.Entry<Integer,Integer> element : numMap.entrySet()) {
                max = Math.max(max, element.getKey());
            }
            result.add(max);
        }

        return result;
    }
}
