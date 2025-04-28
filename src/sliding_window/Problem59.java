package sliding_window;

public class Problem59 {
    public static void main(String[] args) {
        int[] arr = {8, -1, 3, 4, -5, 6};
        int k = 3;

        System.out.println(maxSumCircular(arr, k));
    }

    public static int maxSumCircular(int[] arr, int k) {

        int sum = 0;

        int n = arr.length;

        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        for(int right = 1; right < n; right++) {
            sum += arr[(right + k - 1) % n];
            sum -= arr[(right - 1) % n];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
