package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem23 {
    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupedShifted(input));
    }


    public static List<List<String>> groupedShifted(String[] input) {
        Map<String, List<String>> groupingMap = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            String key = getKey(input[i]);

            groupingMap.putIfAbsent(key, new ArrayList<>());
            groupingMap.get(key).add(input[i]);
        }

        return new ArrayList<>(groupingMap.values());
    }

    public static String getKey(String word) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 1; i < word.length(); i++) {

            int diff = (word.charAt(i) - word.charAt(i - 1) + 26) % 26;

            stringBuilder.append(diff).append(",");
        }

         return stringBuilder.toString();
        
    }
}
