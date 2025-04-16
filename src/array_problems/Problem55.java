package array_problems;

public class Problem55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3}; 
        int k = 7;        

        System.out.println(smallestSumSubArray(nums, k));
    }

    public static int smallestSumSubArray(int[] nums, int k) {
        int smallestCount = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum >= k) {
                smallestCount = Math.min(smallestCount, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return smallestCount;
    }
}
