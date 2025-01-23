package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem37 {
    public static void main(String[] args) {
        int[] input = {3,2,3};
        
        System.out.println(majorityElement(input));
    }

    public static int majorityElement(int[] input) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : input) {
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);

            if(freqMap.get(num) > input.length/2) {
                return num;
            } 
        }

        return -1;
    }
}
