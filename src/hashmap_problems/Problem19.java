package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem19 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(String.format("longest consecutive length -> %s", longestConsecutiveArr(nums)));
    }

    public static int longestConsecutiveArr(int[] nums){
        Map<Integer, Integer> arrMap = new HashMap<>();
        int longestLength = 0;

        for(int num : nums){
            if(arrMap.containsKey(num)){
                continue;
            }

            int left = arrMap.getOrDefault(num - 1, 0);
            int right = arrMap.getOrDefault(num + 1, 0);

            int curentLength = left + right + 1;

            longestLength = Math.max(longestLength, curentLength);

            arrMap.put(num, curentLength);
            arrMap.put(num - left, curentLength);
            arrMap.put(num + right, curentLength);
        }

        return longestLength;
    }
}
