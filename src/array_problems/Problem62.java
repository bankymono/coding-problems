package array_problems;

import java.util.*;

public class Problem62 {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(words));
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> grouped = new HashMap<>();

        for(String word : words) {
            char[] wordArray = word.toCharArray();

            Arrays.sort(wordArray);

            String sortedWord = new String(wordArray);

            grouped.putIfAbsent(sortedWord, new ArrayList<>());
            grouped.get(sortedWord).add(word);
        }

        return new ArrayList<>(grouped.values());
    }
}
