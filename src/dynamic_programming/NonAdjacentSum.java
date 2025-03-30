package dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonAdjacentSum {
    public static void main(String[] args) {
        System.out.println(nonAdjacentSum(List.of(2, 4, 5, 12)));
    }

    public static int nonAdjacentSum(List<Integer> nums) {
        return nonAdjacentSum(nums, 0, new HashMap<>());
    }

    public static int nonAdjacentSum(List<Integer> nums, int i, Map<Integer, Integer> memo) {
        if(memo.containsKey(i)) return memo.get(i);
        if(i >= nums.size()){
            return 0;
        }

        int result = Math.max(nums.get(i) + nonAdjacentSum(nums, i+2, memo), nonAdjacentSum(nums, i+1, memo));

        memo.put(i, result);
        return result;
    }

}
