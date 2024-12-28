package hashmap_problems;


import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        String[] input =  {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(String.format("grouped anagram -> %s", groupAnagram(input)));
    }

    public static List<List<String>> groupAnagram(String[] input){
        Map<String, List<String>> groupedAnagram = new HashMap<>();

        for(String word : input){
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sortedWord = new String(wordChars);

            groupedAnagram.putIfAbsent(sortedWord, new ArrayList<>());
            groupedAnagram.get(sortedWord).add(word);
        }

        return new ArrayList<>(groupedAnagram.values());
    }
}
