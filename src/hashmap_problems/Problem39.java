package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem39 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(String.format("duplicates -> %s", findDuplicate(nums)));
    }

    public static List<Integer> findDuplicate(int[] nums){
        Map<Integer, Integer> numFreq = new HashMap<>();

        List<Integer> result = new ArrayList<>();


        for(int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num,0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
