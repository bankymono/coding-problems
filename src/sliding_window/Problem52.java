package sliding_window;

public class Problem52 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;   
        System.out.println(smallestSubArray(nums, target));
    }

    public static int smallestSubArray(int[] nums, int target) {
        int left = 0;
        int smallestCount = Integer.MAX_VALUE;
        int sum = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum >= target) {
                smallestCount =Math.min(smallestCount, right - left + 1);
                sum -= nums[left];

                left++;
            }
        }

        return smallestCount;
    }
}
