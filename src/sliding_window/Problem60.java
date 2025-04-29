package sliding_window;

public class Problem60 {
    public static void main(String[] args) {
        int[] arr = {4, -2, 5, 3, -6, 2, 1};
        int k = 3;

        System.out.println(minSmallestCircle(arr, k));
    }

    public static int minSmallestCircle(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int minSum = sum;

        for(int i = 1; i < n; i++) {
            sum += nums[(i + k - 1) % n];
            sum -= nums[(i - 1) % n];

            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }
}
