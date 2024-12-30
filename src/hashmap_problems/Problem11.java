package hashmap_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem11 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(String.format("input -> %s, output -> %s", Arrays.toString(nums), Arrays.toString(solveTwoSum(nums, target))));
    }

    public static int[] solveTwoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; ++i){
            int compliment = target - nums[i];

            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
