package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem12 {
    public static void main(String[] args) {
       int[] fruits = {1,2,1,3,4,3,5,1,2};

       System.out.println(maxNumOfFruits(fruits));
    }

    public static int maxNumOfFruits(int[] fruits) {
        Map<Integer, Integer> fruitMap = new HashMap<>();

        int left = 0;
        int longestFruitArray = 0;

        for(int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];
            fruitMap.put(currentFruit, fruitMap.getOrDefault(currentFruit, 0) + 1);

            while(fruitMap.size() > 2) {
                int leftFruit = fruits[left];

                fruitMap.put(leftFruit, fruitMap.get(leftFruit) - 1);

                if(fruitMap.get(leftFruit) == 0) {
                    fruitMap.remove(leftFruit);
                }
                left++;
            }

            longestFruitArray = Math.max(longestFruitArray, right - left + 1);
        }

        return longestFruitArray;
    }
}
