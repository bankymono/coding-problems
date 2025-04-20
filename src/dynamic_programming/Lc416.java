package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Lc416 {
    public static void main(String[] args) {
        int[] nums ={2,2,3,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int avg = sum/2;

        System.out.println("avg -> " + avg);
        System.out.println();

        return canPartition(avg, nums, 0, new HashMap<>());
    }

    public static boolean canPartition(int avg, int[] nums, int index, Map<String, Boolean> memo){
        String key = avg + "," + index;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(avg == 0) {
            return true;
        }

        if(index >= nums.length || avg < 0) {
            return false;
        }

        boolean canAchieve = canPartition(avg - nums[index], nums, index + 1, memo);
        boolean canNotAchieve = canPartition(avg, nums, index + 1, memo);

        boolean result = canAchieve || canNotAchieve;

        memo.put(key, result);

        return result;
    }


}
