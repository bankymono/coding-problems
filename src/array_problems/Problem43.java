package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem43 {
    public static void main(String[] args) {
        String s = "swiss";

        System.out.println(firstNonRepeated(s));
    }

    public static char firstNonRepeated(String s) {
        Map<Character,Integer> charMap = new HashMap<>();

        for(char ch : s.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if(charMap.get(currentChar) == 1) return currentChar;
        }

        return '\0';
    }
}
