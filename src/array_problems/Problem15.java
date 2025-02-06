package array_problems;

public class Problem15 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 11;
        System.out.println(longestSubArr(nums, k));
    }

    public static int longestSubArr(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int maxLength = 0;
        int sum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum > k) {
                sum -= nums[left];
                left++;
            }

            if(sum > maxSum) {
                maxSum = sum;
                maxLength = right - left + 1;
            }
        }

        return maxLength;
    }
}
