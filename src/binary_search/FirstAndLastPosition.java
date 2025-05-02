package binary_search;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int first = search(nums, target, true);
        int last = search(nums, target, false);

        ans[0] = first;
        ans[1] = last;
        return ans;
    }


    public static int search(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target > nums[mid]) {
                start = mid + 1;
            } else if( target < nums[mid]) {
                end = mid - 1;
            } else {
                ans = mid;
                if(isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
