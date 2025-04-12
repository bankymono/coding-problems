package array_problems;

public class Problem52 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 11;

        System.out.println(subArrayWithMpstK(nums, k));       
    }

    public static int subArrayWithMpstK(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int longest = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            if(sum > k) {
                sum -= nums[left];
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
