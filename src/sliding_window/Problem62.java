package sliding_window;

public class Problem62 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 5, 10, 15};
        int k = 3;

        System.out.println(maxAvg(arr, k));
    }

    public static double maxAvg(int[] arr, int k) {
        int n = arr.length;

        double maxAvg = 0;

        int sum = 0;
        double avg = 0;

        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }

        avg = (double) sum /k;
        maxAvg = avg;

        for(int i = 1; i < n; i++) {
            sum = sum + arr[(i + k - 1) % n] - arr[(i - 1) % n];

            avg = (double) sum / k;

            maxAvg = Math.max(avg, maxAvg);
        }

        return maxAvg;
    }
}
