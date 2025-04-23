package dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HowSum {
    public static void main(String[] args) {
        System.out.println((howSum(8, new int[]{6, 4, 4,8})));
    }

    public static List<Integer> howSum(int targetSum, int[] nums) {
        ArrayList<Integer>[] dp = new ArrayList[targetSum + 1];
        dp[0] = new ArrayList<>();

        for(int i = 0; i < targetSum; i++) {
            if(Objects.nonNull(dp[i])){
                for(int num : nums) {
                    if(i+num <= targetSum){
                        if(dp[i + num] == null) {
                            dp[i + num] = new ArrayList<>(dp[i]);
                            dp[i+num].add(num);
                        }

                    }
                }
            }
        }

        System.out.println(Arrays.toString(dp));
    return dp[targetSum];
    }

}
