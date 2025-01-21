package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem28 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(String.format("input is %s, length of substring -> %s", input, longestSubstring(input)));
    }

    public static int longestSubstring(String input) {
        int maxLength = 0;
        int left = 0;

        Map<Character, Integer> charMap = new HashMap<>();


        for(int right = 0; right < input.length(); right++) {
            char currentChar = input.charAt(right);

            if(charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left +1);
        }

        return maxLength;
    }
}
