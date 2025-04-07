package array_problems;

import java.util.*;

public class Problem47 {
    public static void main(String[] args) {
        int[] nums ={2, 7, 11, 15};
        int target = 9;

        System.out.println(twoSums(nums, target));    
    }

    public static List<Integer> twoSums(int[] nums, int target) {
        Map<Integer, Integer> windowMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

            int diff = target - currentNum;

            if(windowMap.containsKey(diff)){
                return Arrays.asList(windowMap.get(diff), right);
            }

            windowMap.put(nums[right], right);
        }

        return result;
    }
}
