package sliding_window;

public class Problem31 {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int k = 5;
        System.out.println(longestAbsDiffArr(nums,k));
    }

    public static int longestAbsDiffArr(int[] nums, int k) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int longest = 0;

        for(int right = 0; right < nums.length; right++) {
            max = Math.max(nums[right], max);
            min = Math.min(nums[right],min);

            while((max - min) > k) {
                left++;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for(int i = left; i <=right; i++) {
                    min = Math.min(nums[i], min);
                    max = Math.max(nums[i], max);
                }
            }


            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
