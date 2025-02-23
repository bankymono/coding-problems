package sliding_window;

public class Problem29 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int k = 7;

        System.out.println(shortestSumToK(nums, k));
    }

    public static int shortestSumToK(int[] nums, int k) {
        int left = 0;
        int shortest = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];


            while(sum >= k) {
                shortest = Math.min(right - left + 1, shortest);
                sum -= nums[left];
                left++;
            }
        }

        return shortest == Integer.MAX_VALUE ? 0: shortest;
    }

    
}
