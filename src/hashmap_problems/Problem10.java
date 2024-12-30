package hashmap_problems;

import java.util.*;

public class Problem10 {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(String.format("input -> %s, output -> %s", Arrays.toString(input), groupedAnagram(input)));
        
    }

    public static List<List<String>> groupedAnagram(String[] input){
        Map<String, List<String>> anagramGroup = new HashMap<>();

        for(String word : input){
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sortedWord = new String(wordArray);

            anagramGroup.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGroup.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagramGroup.values());
    }
}
