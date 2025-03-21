package dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BestSum {
    public static void main(String[] args) {
        System.out.println(bestSum(8, new int[]{6, 8, 4, 4}));
    }

    public static List<Integer> bestSum(int targetSum, int[] nums) {
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

                result.add(num);
                if(result.size() < minLength) {
                    finalResult = result;
                    minLength = result.size();
                }
            }
        }
        return finalResult;
    }
}
