package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem28 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(twoSumArray(nums, target));
    }

    public static List<Integer> twoSumArray(int[] nums, int target) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];


            if(arrMap.containsKey(complement)) {

                result.add(arrMap.get(complement));
                result.add(i);
                return result;
            }

            arrMap.put(nums[i], i);
        }

        return result;
    }
}
