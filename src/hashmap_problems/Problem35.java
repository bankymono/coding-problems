package hashmap_problems;

import java.util.*;

public class Problem35 {
    public static void main(String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicate(input));
        
    }

    public static List<Integer> findDuplicate(int[] input) {
        Map<Integer, Integer> elemFreq = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < input.length; i++) {
            elemFreq.put(input[i], elemFreq.getOrDefault(input[i], 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : elemFreq.entrySet()) {
            if( entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
