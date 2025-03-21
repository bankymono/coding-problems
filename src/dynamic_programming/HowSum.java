package dynamic_programming;

import java.util.*;

public class HowSum {
    public static Map<Integer,List<Integer>> memo = new HashMap<>();
    public static void main(String[] args) {

        System.out.println(howSum(11459, new int[]{6, 4, 8}));
    }

    public static List<Integer> howSum(int targetSum, int[] nums) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);

        if(targetSum == 0) {
            return new ArrayList<>();
        }
        if(targetSum < 0) {
            return null;
        }

        for(int num : nums) {
            List<Integer> ans = howSum(targetSum - num, nums);
            if(Objects.nonNull(ans)) {
                ans.add(num);
                memo.put(targetSum, ans);
                return memo.get(targetSum);
//                return ans;
            }
        }
        memo.put(targetSum,null);
        return memo.get(targetSum);
     }
}
