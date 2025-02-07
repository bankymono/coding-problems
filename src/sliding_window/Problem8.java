package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem8 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstring(s));
    }

    public static int longestSubstring(String s) {

        int left = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;


        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if(charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                left = charMap.get(currentChar) + 1;
            }

            charMap.put(currentChar, right);

            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}
