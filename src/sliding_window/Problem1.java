package sliding_window;

public class Problem1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 10;
        System.out.println(maxSumSubArray(nums, target));
    }

    public static int maxSumSubArray(int[] nums, int target) {
        int left = 0;
        int maxSum = 0;
        int currentSum = 0;


        for(int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while(currentSum >  target) {
                currentSum -= nums[left];
                left++;
            }


            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
