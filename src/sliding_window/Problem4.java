package sliding_window;

public class Problem4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 11;

        System.out.println(longestSubArrayMostSumK(nums, k));
    }

    public static int longestSubArrayMostSumK(int[] nums, int k) {
        int maxLength = 0;

        int currentSum = 0;

        int left = 0;

        int right;

        for(right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while(currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
