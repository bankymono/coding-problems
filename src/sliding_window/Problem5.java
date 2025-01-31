package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem5 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithMostK(nums, k) - subarrayWithMostK(nums, k - 1);
    }

    public static int subarrayWithMostK(int[] nums, int k) {
        Map<Integer, Integer> charMap = new HashMap<>();
        int count = 0;
        int left = 0;


        for(int right = 0; right < nums.length; ++right) {
            charMap.put(nums[right], charMap.getOrDefault(nums[right],0)+1);

            while(charMap.size() > k){
                charMap.put(nums[left], charMap.get(nums[left]) - 1);
                if(charMap.get(nums[left]) == 0) {
                    charMap.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
