package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem47 {
    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

        System.out.println(groupShiftedArray(input));
    }

    public static List<List<String>> groupShiftedArray(String[] input) {
        Map<String, List<String>> shiftedGroup = new HashMap<>();

        for(String word : input) {
            String key = getShiftKey(word);

            shiftedGroup.putIfAbsent(key, new ArrayList<>());
            shiftedGroup.get(key).add(word);
        }


        return new ArrayList<>(shiftedGroup.values());
    }

    public static String getShiftKey(String word) {

        StringBuilder pattern = new StringBuilder();
        char[] wordArray = word.toCharArray();

        for(int i = 1; i < wordArray.length; i++) {

            pattern.append(wordArray[i - 1] - wordArray[i]).append(",");
        }

        return pattern.toString();
    }
}
