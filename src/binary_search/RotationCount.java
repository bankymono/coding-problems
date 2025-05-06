package binary_search;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(printCountRotations(arr));
    }

    public static int printCountRotations(int[] arr) {
        int pivot = findPivotWithDuplicate(arr);
        if(pivot == -1) {
            return 0;
        }

        return pivot + 1;
    }

    public static int findPivotWithDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end ) {
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if(mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
                if(nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if(nums[end] < nums[end - 1]) {
                    return end - 1;
                }

                end--;
            }

            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
