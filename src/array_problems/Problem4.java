package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4 {
    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupShiftedString(input));
    }

    public static List<List<String>> groupShiftedString(String[] input) {
        Map<String, List<String>> groupedResults = new HashMap<>();

        for(String word : input) {
            String key = getPattern(word);

            groupedResults.putIfAbsent(key, new ArrayList<>());
            groupedResults.get(key).add(word);
        }

        return new ArrayList<>(groupedResults.values());
    }

    private static String getPattern(String word) {
        StringBuilder pattern = new StringBuilder();
        char[] wordArray = word.toCharArray();

        for(int i = 1; i < wordArray.length; i++) {
            int diff = (wordArray[i] - wordArray[i - 1] + 36) % 36;

            pattern.append(diff).append(",");
        }

        return pattern.toString();
    }
}
