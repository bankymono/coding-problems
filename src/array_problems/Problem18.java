package array_problems;

public class Problem18 {
    public static void main(String[] args) {
       int[] nums = {2,3,1,2,4,3};
       int k = 7;

       System.out.println(smallestSubarraySumGreaterThanK(nums, k));
    }

    public static int smallestSubarraySumGreaterThanK(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE; // To track the smallest subarray length
        int currentSum = 0; // To store the sum of the current window
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right]; // Add the current element to the window sum

            // Shrink the window from the left side as long as the sum is greater than k
            while (currentSum > k) {
                minLength = Math.min(minLength, right - left + 1); // Update the minLength
                currentSum -= nums[left]; // Remove the left element from the window
                left++; // Move the left pointer to shrink the window
            }
        }

        // If no valid subarray was found, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
