package array_problems;

import java.util.*;

public class Problem44 {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupedAnagrams(input));
    }

    public static List<List<String>> groupedAnagrams(String[] input) {
        Map<String, List<String>> anagramGrp = new HashMap<>();


        for(String word : input) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sortedWord = new String(wordArray);

            anagramGrp.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGrp.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagramGrp.values());
    }


}
