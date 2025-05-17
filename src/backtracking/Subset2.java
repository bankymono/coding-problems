package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};
        int[] nums = {1,2,2};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(resultList, new ArrayList<>(), nums, 0);

        return resultList;
    }

    public static void backtrack(List<List<Integer>> resultList, List<Integer> tempset, int[] nums, int start) {
        if(resultList.contains(tempset)) {
            return;
        }
        resultList.add(new ArrayList<>(tempset));

        for(int i = start; i < nums.length; i++) {
            tempset.add(nums[i]);
            backtrack(resultList, tempset, nums, i + 1);
            tempset.remove(tempset.size() - 1);
        }
    }

}
