package sliding_window;

public class Problem25 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;

        System.out.println(longestSumMostK(nums, k));
    }

    public static int longestSumMostK(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        int longest = 0;

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];


            while(sum > k) {
                sum -= nums[left];
                left++;
            }


            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
