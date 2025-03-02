package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem36 {
    public static void main(String[] args) {
     int[] nums = {1,2,2,3,1,4,2};

     System.out.println(minArrWithRepeeat(nums));   
    }

    public static int minArrWithRepeeat(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        int maxFreq = 0;

        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            freqMap.put(currentNum, freqMap.getOrDefault(currentNum, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(currentNum));

            if(!firstIndexMap.containsKey(currentNum)){
                firstIndexMap.put(currentNum, i);
            }

            lastIndexMap.put(currentNum, i);
        }

        int minArr = nums.length;

        for(int val : freqMap.keySet()){
            if(freqMap.get(val) == maxFreq){
                minArr = Math.min(minArr, lastIndexMap.get(val) - firstIndexMap.get(val) + 1);
            }
        }

        return minArr;
    }
}
