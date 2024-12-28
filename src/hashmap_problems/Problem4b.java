package hashmap_problems;

import java.util.*;

public class Problem4b {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagram(input));
    }

    public static List<List<String>> groupAnagram(String[] input){
        Map<String, List<String>> groupedAnagram = new HashMap<>();

        for(String word : input){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            groupedAnagram.putIfAbsent(sortedWord, new ArrayList<>());
            groupedAnagram.get(sortedWord).add(word);
        }

        return new ArrayList<>(groupedAnagram.values());
    }
}
