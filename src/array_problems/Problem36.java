package array_problems;

public class Problem36 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minimumSumSubArr(nums, target));
    }

    public static int minimumSumSubArr(int[] nums, int target) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];


            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
