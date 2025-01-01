package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem16 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(findMajorityElement(nums));
    }

    public static int findMajorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int result = 0;
        int ans = -1;

        for(int num : nums) {

            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);

            if(freqMap.get(num) > result){
                ans = num;
                result = freqMap.get(num);
            }

        }

        return ans;
    }
}
