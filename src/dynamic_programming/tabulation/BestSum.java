package dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.List;

public class BestSum {
    public static void main(String[] args) {
        System.out.println(bestSum(693, new int[]{1, 2, 5, 25}));
//        System.out.println(bestSum(8, new int[]{6, 4, 4}));
    }

    public static List<Integer> bestSum(int target, int[] nums) {
        List<Integer>[] dp = new ArrayList[target + 1];

        dp[0] = new ArrayList<>();

        for(int i = 0; i <= target; i++) {
            if(dp[i] != null) {
                for(int num : nums) {
                    if(i + num <= target) {
                        if(dp[i + num] == null) {
                            dp[i + num] = new ArrayList<>();
                            dp[i + num].addAll(dp[i]);
                            dp[i + num].add(num);
                        } else {
                            var arr = new ArrayList<>(dp[i]);
                            arr.add(num);
                            if(arr.size() <dp[i + num].size()) {
                                dp[i + num] = arr;
                            }
                        }
                    }
                }
            }

        }

        return dp[target];
    }
}
