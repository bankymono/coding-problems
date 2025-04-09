package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem49 {
    public static void main(String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};

        System.out.println(findDuplicate(input));        
    }

    public static List<Integer> findDuplicate(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        for(int num : nums) {
            if(numMap.get(num) > 1 && !result.contains(num)){
                result.add(num);
            }
        }

        return result;
    }
}
