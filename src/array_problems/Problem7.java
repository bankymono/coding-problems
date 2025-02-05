package array_problems;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupedAnagrams(input));
    }

    public static List<List<String>> groupedAnagrams(String[] input) {

        Map<String, List<String>> anagramGrp = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            String word = input[i];

            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);

            String sortedWord = new String(wordArray);

            anagramGrp.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGrp.get(sortedWord).add(word);
        }


        return new ArrayList<>(anagramGrp.values());
    }
}
