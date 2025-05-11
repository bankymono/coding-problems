package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
//        int[] nums = {0,1};
        System.out.println(permutations(nums));
    }

    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }


    public static void backtracking(List<List<Integer>> resultList, List<Integer> tempset, int[] nums, boolean[] boolList) {

        if(tempset.size() == nums.length && !resultList.contains(tempset)) {
            resultList.add(new ArrayList<>(tempset));
        }


        for(int i = 0; i < nums.length; i++) {
            if(boolList[i]){
                continue;
            }

            tempset.add(nums[i]);
            boolList[i] = true;
            backtracking(resultList,tempset,nums, boolList);
            tempset.remove(tempset.size() - 1);
            boolList[i] = false;
        }
    }

}
