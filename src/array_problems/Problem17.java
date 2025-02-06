package array_problems;

import java.util.ArrayList;
import java.util.List;

public class Problem17 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(windowMax(nums, k));
    }

    public static List<Integer> windowMax(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= nums.length - k; i++) {
            int max = 0;
            for(int j = i; j < i + k; j++ ){
                max = Math.max(max, nums[j]);
            }
            result.add(max);
        }

        return result;
    }
}
