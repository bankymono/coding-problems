package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem35 {
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(longestSubstringWithoutRepeating(s));
    }

    public static int longestSubstringWithoutRepeating(String s) {
        Map<Character, Integer> charPos = new HashMap<>();
        int maxLength = 0;

        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if(charPos.containsKey(currentChar) && left <= charPos.get(currentChar)) {
                left = charPos.get(currentChar) + 1;
            }

            charPos.put(currentChar, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
