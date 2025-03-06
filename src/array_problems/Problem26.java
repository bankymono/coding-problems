package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem26 {
    public static void main(String[] args) {
        String input = "swiss";

        System.out.println(firstNonRepeating(input));
    }

    public static char firstNonRepeating(String input) {
        Map<Character, Integer> charMap = new HashMap<>();


        for(char ch : input.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if(charMap.get(currentChar) == 1) {
                return currentChar;
            }
        }

        return '\0';
    }
}
