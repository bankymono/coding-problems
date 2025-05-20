package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem67 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            numMap.put(currentNum, numMap.getOrDefault(currentNum, 0) + 1);
            if(numMap.get(currentNum) == 2) {
                result.add(currentNum);
            }


        }

        return result;
    }
}
