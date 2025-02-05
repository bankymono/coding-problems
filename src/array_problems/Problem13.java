package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem13 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(duplicatElems(nums));
    }

    public static List<Integer> duplicatElems(int[] nums) {
        Map<Integer, Integer> elemMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int elem = nums[i];

            elemMap.put(elem, elemMap.getOrDefault(elem, 0) + 1);

            if(elemMap.get(elem) == 2) {
                result.add(elem);
            }


        }

        return result;
    }
}
