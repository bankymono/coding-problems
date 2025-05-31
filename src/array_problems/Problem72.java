package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem72 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(maxCollection(nums, k));
    }

    public static List<Integer> maxCollection(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int maxNum;
        for(int right = 0; right <= nums.length - k; right++) {
            maxNum = Integer.MIN_VALUE;
            for(int i = right; i < right + k; i++) {
                maxNum = Math.max(nums[i], maxNum);
            }
            result.add(maxNum);
        }

        return result;
    }
}
