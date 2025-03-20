package sliding_window;

public class Problem40 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 5, 10, 15}; 
        int k = 3;   

        System.out.println(maximumAverage(arr, k));
    }

    public static double maximumAverage(int[] arr, int k) {
        double maxAverage;
        int sum = 0;
        double average = 0;
        int n = arr.length;

        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }

        average =  (double) sum / k;
        maxAverage = average;

        for(int i = 1; i < n; i++ ) {
            sum -= arr[i - 1];
            sum += arr[(i + k - 1) % n];

            average = (double)sum / k;

            maxAverage = Math.max(average, maxAverage);
        }

        return maxAverage;

    }
}
