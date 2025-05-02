package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem63 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5};
    

        System.out.println(subArr(arr));
    }


    public static int subArr(int[] nums) {
        Map<Integer, Integer> winMap = new HashMap<>();

        int n = nums.length;
        int left = 0;

        int longest = Integer.MIN_VALUE;

        for(int right = 0; right < 2 * n; right++) {

            int currentNum = nums[right % n];

            while (winMap.containsKey(currentNum)) {
                int leftNum = nums[left % n];
                winMap.put(leftNum, winMap.get(leftNum) - 1);

                if (winMap.get(leftNum) == 0) {
                    winMap.remove(leftNum);
                }

                left++;
            }

            winMap.put(currentNum, winMap.getOrDefault(currentNum, 0) + 1);
            if (right - left + 1 > n) {
                int removeNum = nums[left % n];
                winMap.put(removeNum, winMap.get(removeNum) - 1);
                if (winMap.get(removeNum) == 0) {
                    winMap.remove(removeNum);
                }
                left++;
            }


            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
