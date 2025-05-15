package recursion.arrays;

import java.util.ArrayList;
import java.util.List;

public class Find {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,5,6,8};
//        System.out.println(findInArray(arr, 4, 0));
//        System.out.println(findIndices(new ArrayList<>(), arr, 3, 0));
        System.out.println(findIndicesTwo( arr, 3, arr.length - 1));
    }

    public static int findInArray(int[] nums, int target, int index) {
        if(index == nums.length) {
            return -1;
        }

        if(target == nums[index]) {
            return index;
        }
        return findInArray(nums, target, index + 1);
    }

    public static List<Integer> findIndices(List<Integer> result,  int[] nums, int target, int index) {
        if(index == nums.length) {
            return result;
        }

        if(target == nums[index]) {
            result.add(index);
        }

        return findIndices(result, nums, target, index + 1);
    }

    public static List<Integer> findIndicesTwo(int[] nums, int target, int index) {
        if(index == -1) {
            return new ArrayList<>();
        }

        List<Integer> ans = findIndicesTwo(nums, target, index - 1);

        if(target == nums[index]) {
            ans.add(index);
        }

        return ans;
    }
}
