package hashmap_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem22 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] result = {-1, -1};


        for(int i = 0; i < nums.length; ++i){

            if(indexMap.containsKey(target - nums[i])){
                return new int[] {indexMap.get(target - nums[i]), i};
            }

            indexMap.put(nums[i], i);
        }

        return result;
    }
}
