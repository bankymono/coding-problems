package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem42 {
    public static void main(String[] args) {
        int[] fruits = {1,2,1,3,4,3,5,1,2};
        int k = 2;
        System.out.println(maxFruit(fruits, k));    
    }

    public static int maxFruit(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        int left = 0;
        int maxFruits = Integer.MIN_VALUE;

        for(int right = 0; right < nums.length; right++) {
            int currentFruit = nums[right];

            numFreq.put(currentFruit, numFreq.getOrDefault(currentFruit, 0) + 1);

            while(numFreq.size() > k) {
                int leftFruit = nums[left];

                numFreq.put(leftFruit, numFreq.get(leftFruit) - 1);

                if(numFreq.get(leftFruit) == 0){
                    numFreq.remove(leftFruit);
                }

                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }


}
