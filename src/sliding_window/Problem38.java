package sliding_window;

public class Problem38 {
    public static void main(String[] args) {
        int[] nums = {4, -2, 5, 3, -6, 2, 1};
                int k = 3;

        System.out.println(minSumCircular(nums, k));
    }

    public static int minSumCircular(int[] nums, int k) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        minSum = sum;

        for(int i = 1; i < nums.length; i++) {
            sum -= nums[i - 1];
            sum += nums[(i + k - 1) % nums.length];

            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }
}
