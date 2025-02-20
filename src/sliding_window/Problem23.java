package sliding_window;

import java.util.*;

public class Problem23 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(findAllDuplicates(nums));
    }

    public static Set<Integer> findAllDuplicates(int[] nums) {
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> freqMap = new HashMap<>();


        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if (freqMap.get(num) == 2) { // Add to result when it appears twice
                result.add(num);
            }
        }

        return result;
    }
}
