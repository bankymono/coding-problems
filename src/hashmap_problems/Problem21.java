package hashmap_problems;

import java.util.*;

public class Problem21 {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupedAnagrams(input));
    }

    public static List<List<String>> groupedAnagrams(String[] input){
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String word : input){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sortedWord = new String(chars);

            anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
            anagramMap.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
