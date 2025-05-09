package array_problems;

import java.util.*;

public class Problem59 {
    public static void main(String[] args) {
        String [] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupShiftedString(input));
    }

    public static List<List<String>> groupShiftedString(String[] input) {
        Map<String, List<String>> grouped = new HashMap<>();


        for(String word : input) {
            String key = getKey(word);

            grouped.putIfAbsent(key, new ArrayList<>());
            grouped.get(key).add(word);
        }

        return new ArrayList<>(grouped.values());   
    }

    public static String getKey(String word) {
        StringBuilder builder = new StringBuilder();

        for(int i = 1; i < word.length(); i++) {
            builder.append(word.charAt(i) - word.charAt(i - 1)).append(",");
        }

        return builder.toString();
    }
}
