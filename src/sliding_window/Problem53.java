package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem53 {
    public static void main(String[] args) {
        int[] fruits = {1,2,1,3,4,3,5,1,2};

        System.out.println(fruitBasket(fruits));
    }

    public static int fruitBasket(int[] fruits) {
        Map<Integer, Integer> fruitMap = new HashMap<>();
        int left = 0;
        int maxCount = Integer.MIN_VALUE;
        
        for(int right = 0; right < fruits.length; right++) {
            int currentNum = fruits[right];

            fruitMap.put(currentNum, fruitMap.getOrDefault(currentNum, 0) + 1);

            while(fruitMap.size() > 2) {
                int leftFruit = fruits[left];

                fruitMap.put(leftFruit, fruitMap.get(leftFruit) - 1);

                if(fruitMap.get(leftFruit) == 0) {
                    fruitMap.remove(leftFruit);
                }
                left++;
            }

            maxCount = Math.max(right - left + 1, maxCount);
        }

        return  maxCount;
    }
}
