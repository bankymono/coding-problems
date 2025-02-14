package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem22 {
    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

        System.out.println(groupShifedMethod(input));
    }

    public static List<List<String>> groupShifedMethod(String[] input) {
        Map<String, List<String>> grouped = new HashMap<>();

        for (String currentWord : input) {
            String key = getKey(currentWord);

            grouped.putIfAbsent(key, new ArrayList<>());
            grouped.get(key).add(currentWord);
        }

        return new ArrayList<>(grouped.values());
    }

    public static String getKey(String word) {
        StringBuilder keybuilder = new StringBuilder();

        for(int i = 1; i < word.length(); i++) {
            int diff = (word.charAt(i - 1) - word.charAt(i) + 26) % 26;
            keybuilder.append(diff).append(",");
        }

        return keybuilder.toString();
    }
}
