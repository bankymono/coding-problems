package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem41 {
    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

        System.out.println(groupShifted(input));
    }

    public static List<List<String>> groupShifted(String[] input) {
        Map<String, List<String>> grouped = new HashMap<>();

        for(String word : input) {
            String key = getKey(word);

            grouped.putIfAbsent(key, new ArrayList<>());
            grouped.get(key).add(word);
        }

        return new ArrayList<>(grouped.values());
    }

    private static String getKey(String word) {
        StringBuilder key = new StringBuilder();

        for(int i = 1; i < word.length(); i++) {
            key.append(word.charAt(i) - word.charAt(i - 1)).append(",");
        }

        return key.toString();
    }
}
