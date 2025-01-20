package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem25 {
    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupShiftedStrings(input));
    }

    public static List<List<String>> groupShiftedStrings(String[] input) {
        Map<String, List<String>> groupedString = new HashMap<>();

        for(String word : input) {
            String key = getWordKey(word);

            groupedString.putIfAbsent(key, new ArrayList<>());
            groupedString.get(key).add(word);
        }

        return new ArrayList<>(groupedString.values());
    }

    public static String getWordKey(String word) {
        StringBuilder pattern = new StringBuilder();
        for(int i = 1; i < word.length(); i++) {
            int diff = (word.charAt(i)  - word.charAt(i - 1) + 26) % 26;
            pattern.append(diff).append(",");
        }

        return pattern.toString();
    }
}
