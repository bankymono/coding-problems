package binary_search;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 10,9,6,3};
        System.out.println(findInMountainArray(arr, 9));
    }

    public static int findInMountainArray(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);

        int ans = ogbs(arr, target, 0, peak);
        if(ans == -1) {
            ans = ogbs(arr,target, peak + 1, arr.length - 1);
        }

        return  ans;
    }

    public static int ogbs(int[] arr, int target, int start, int end) {
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

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }


}
