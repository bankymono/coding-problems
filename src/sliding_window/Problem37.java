package sliding_window;

public class Problem37 {
    public static void main(String[] args) {
        int[] arr = {8, -1, 3, 4, -5, 6};
        int k = 3;

        System.out.println(maxSumInInCircularArr(arr, k));
    }

        public static int maxSumInInCircularArr(int[] arr, int k) {
            int n = arr.length;
            int maxSum = Integer.MIN_VALUE;

            // Check all possible starting points
            for (int start = 0; start < n; start++) {
                int sum = 0;

                // Collect k elements in circular manner
                for (int i = 0; i < k; i++) {
                    sum += arr[(start + i) % n]; // Wrap around using modulo
                }

                maxSum = Math.max(maxSum, sum);
            }
            return maxSum;
        }

    
}
