package binary_search;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0,2, 3,4,15, 16, 18, 22, 45, 89};
        int[] arr2 = {89,45,22,18,16,15,4,3,0,-4,-12,-18};
        int target = -18;
        int ans = ogbs(arr2, target);
        System.out.println(ans);
    }

    public static int ogbs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start)/ 2;

            if(arr[mid] == target) {
                return mid;
            }

            if(isAsc){
                if(target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return -1;
    }

}
