package hashmap_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem31 {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumSolution(input, target)));
    }

    public static int[] twoSumSolution(int[] input, int target) {
        Map<Integer, Integer> mapFreq = new HashMap<>();

        for(int i = 0; i < input.length; ++i) {
            if(mapFreq.containsKey(target - input[i])) {
                return new int[]{i, mapFreq.get(target - input[i])};
            }

            mapFreq.put(input[i], i);
        }

        return new int[]{-1,-1};
    }
}
