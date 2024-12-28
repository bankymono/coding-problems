package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    public static void main(String[] args) {
        String input =  "apple banana apple orange banana apple";

        Map<String, Integer> wordCount = wordCountFrequency(input);

        System.out.println(wordCount);
    }

    public static Map<String, Integer> wordCountFrequency(String input){
        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = input.split(" ");

        for(String word : words){
            System.out.println(word);
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }
}
