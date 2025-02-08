package sliding_window;

public class Problem9 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minSumSubArr(nums,target));
    }

    public static int minSumSubArr(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];


            while(sum >= target) {
                minSum = Math.min(minSum, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minSum == Integer.MAX_VALUE ? 0 : minSum;
    }
}
