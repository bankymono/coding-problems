package hashmap_problems;

import java.util.*;

public class Problem30 {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(String.format("input -> %s, result -> %s", Arrays.toString(input), groupAnagrams(input)));
    }

    public static List<List<String>> groupAnagrams(String[] input){
        Map<String, List<String>> anagGroups = new HashMap<>();

        for(String word : input) {
            char[] charArrays = word.toCharArray();

            Arrays.sort(charArrays);

            String sortedWord = new String(charArrays);

            anagGroups.putIfAbsent(sortedWord, new ArrayList<>());

            anagGroups.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagGroups.values());
    }
}
