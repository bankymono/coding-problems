package sliding_window;

public class Problem61 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3; 
        int x = 7;

        System.out.println(countSubArrs(arr, k, x));
    }

    public static int countSubArrs(int[] arr, int k, int x) {
        int count = 0;
        int sum = 0;

        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if(sum >= x) {
            count++;
        }

        int n = arr.length;

        for(int i = 1; i < n; i++) {

            sum = sum + arr[(i + k - 1) % n] - arr[(i - 1) % n];
            if(sum >= x) {
                count++;
            }
        }

        return count;
    }


}
