package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        int[] nums = {0,1};
        System.out.println(permutations(nums));
    }

    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtracking(result, new ArrayList<>(), nums);

        return result;
    }

    public static void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] nums){

        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }


        for(int num : nums) {
            if(tempList.contains(num)){
                continue;
            }

            tempList.add(num);
            backtracking(result, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
