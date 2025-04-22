package dynamic_programming.tabulation;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(300, new int[]{5, 3, 8, 8}));
    }

    public static boolean canSum(int targetSum, int[] nums) {
        boolean[] dp = new boolean[targetSum + 1];

        dp[0] = true;

        for(int i = 0; i <= targetSum; i++) {
            if (dp[i]) {
                for (int num : nums) {
                    if (i + num <= targetSum) {
                        dp[i + num] = true;
                    }
                }
            }
        }

        return dp[targetSum];
    }
}
