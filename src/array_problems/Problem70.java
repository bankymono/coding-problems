package array_problems;

public class Problem70 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 11;

        System.out.println(longestSubArray(nums, k));
    }

    public static int longestSubArray(int[] nums, int k) {
        int sum  = 0;
        int left = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];
            sum += currentNum;

            while(sum > k) {
                int leftNum = nums[left];

                sum -= leftNum;

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
