package sliding_window;


import java.util.HashMap;
import java.util.Map;


public class Problem30 {
    public static void main(String[] args) {
        int[] fruits = {1,2,1,2,3,2,2};
        System.out.println(selectFruits(fruits));
    }

    public static int selectFruits(int[] fruits) {
        Map<Integer, Integer> selectedFruitMap = new HashMap<>();

        int left = 0;
        int longest = 0;

        for(int right = 0; right < fruits.length; right++) {
            selectedFruitMap.put(fruits[right], selectedFruitMap.getOrDefault(fruits[right], 0) + 1);

            while(selectedFruitMap.size() > 2) {
                int leftNum = fruits[left];
                selectedFruitMap.put(leftNum, selectedFruitMap.get(leftNum) - 1);

                if(selectedFruitMap.get(leftNum) == 0) {
                    selectedFruitMap.remove(leftNum);
                }
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return  longest;
    }
}
