package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem57 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(longestSubstring(input));
    }

    public static int longestSubstring(String input) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int right = 0; right < input.length(); right++) {
            char currentChar = input.charAt(right);

            if(charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }



        return maxLength;
    }
}
