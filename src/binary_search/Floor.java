package binary_search;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0,2, 3,4,15, 16, 18, 22, 45, 89};
        int target = 13;
        int ans = floor(arr, target);

        System.out.println(arr[ans]);
    }

    public static int floor(int[] arr, int target) {
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

        return end;
    }
}
