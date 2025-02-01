package sliding_window;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(slidingWindow(nums, k));
    }

    public static List<Integer> slidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i <= nums.length - k; i++) {
            int maxValue = nums[i];
            for (int j = i; j < i + k; j++) {
                maxValue = Math.max(nums[j], maxValue);
            }
            result.add(maxValue);
        }

        return result;
    }
}
