package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem61 {
    public static void main(String[] args) {
        String word = "swiss";
        System.out.println(firstNonRepeating(word));
    }

    public static char firstNonRepeating(String word) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(char ch : word.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(charMap.get(currentChar) == 1) {
                return currentChar;
            } 
        }

        return '\0';
    }
}
