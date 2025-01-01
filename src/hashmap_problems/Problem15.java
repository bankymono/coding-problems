package hashmap_problems;

import java.util.*;

public class Problem15 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(findDuplicatElement(nums));
    }

    public static Set<Integer> findDuplicatElement(int[] nums){
        Map<Integer,Integer> freqMap = new HashMap<>();
        Set<Integer> result = new HashSet<>();

        for(int elem : nums) {
            if(freqMap.containsKey(elem)){
                result.add(elem);
            }

            freqMap.put(elem, freqMap.getOrDefault(elem,0) + 1);
        }

        return result;
    }
}
