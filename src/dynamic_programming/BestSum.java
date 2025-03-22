package dynamic_programming;

import java.util.*;

public class BestSum {
    public static Map<Integer,List<Integer>> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(bestSum(693, new int[]{1, 2, 5, 25}));
    }

    public static List<Integer> bestSum(int targetSum, int[] nums) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        List<Integer> finalResult = null;

        if(targetSum == 0) {
            return new ArrayList<>();
        }
        if(targetSum < 0) {
            return finalResult;
        }

        int minLength = Integer.MAX_VALUE;

        for (int num : nums) {
            List<Integer> result = bestSum(targetSum - num, nums);
            if(Objects.nonNull(result)) {

                result = new ArrayList<>(result);

                result.add(num);
                if(result.size() < minLength) {
                    finalResult = result;
                    minLength = result.size();
                }
            }
        }

        memo.put(targetSum, finalResult);
        return memo.get(targetSum);
    }
}
