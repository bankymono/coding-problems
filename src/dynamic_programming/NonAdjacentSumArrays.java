package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonAdjacentSumArrays {
    public static void main(String[] args) {
        System.out.println(nonAdjacentArrays(List.of(2, 4, 5, 12)));
    }

    public static List<List<Integer>> nonAdjacentArrays(List<Integer> nums) {
        return nonAdjacentArrays(nums, 0, new HashMap<>());
    }

    public static List<List<Integer>> nonAdjacentArrays(List<Integer> nums, int i, Map<Integer, List<List<Integer>>> memo) {
        if(memo.containsKey(i)) return memo.get(i);
        if(i >= nums.size()){
            List<List<Integer>> res = new ArrayList<>();

            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> result = new ArrayList<>();

        List<List<Integer>> leftTree = nonAdjacentArrays(nums, i + 2, memo);
        for(List<Integer> arr : leftTree){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums.get(i));
            temp.addAll(arr);
            result.add(temp);
        }

        List<List<Integer>> rightTree = nonAdjacentArrays(nums, i+1, memo);

        result.addAll(rightTree);

//        nums.get(i) + nonAdjacentArrays(nums, i+2, memo), nonAdjacentArrays(nums, i+1, memo));

        memo.put(i, result);
        return result;
    }

}
