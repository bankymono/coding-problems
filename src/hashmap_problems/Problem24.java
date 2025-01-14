package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem24 {
    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";

        System.out.println(String.format("%s and %s are anagrams -> %s", input1, input2, isAnagram(input1, input2)));
    }

    public static boolean isAnagram(String input1, String input2) {
        Map<Character, Integer> charOneFreq = new HashMap<>();
        Map<Character, Integer> charTwoFreq = new HashMap<>();

        for(Character chars : input1.toCharArray()){
            charOneFreq.put(chars, charOneFreq.getOrDefault(chars, 0) + 1);
        }

        for(Character chars : input2.toCharArray()){
            charTwoFreq.put(chars, charTwoFreq.getOrDefault(chars, 0) + 1);
        }

        return charOneFreq.equals(charTwoFreq);
    }
}
