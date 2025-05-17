package array_problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem65 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(sumTwoNumbers(nums,target));
    }

    public static List<Integer> sumTwoNumbers(int[] nums, int target) {
        Map<Integer, Integer> charMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            if(charMap.containsKey(complement)) {
                return List.of(charMap.get(complement),i);                
            }
            charMap.put(currentNum, i);
        }

        return List.of(-1,-1);
    }
}
