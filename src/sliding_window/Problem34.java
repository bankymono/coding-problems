package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem34 {
    public static void main(String[] args) {
        String input = "abcabcbb";

        System.out.println(longestSubString(input));        
    }

    public static int longestSubString(String input){
        Map<Character, Integer> charIndex = new HashMap<>();
        int left = 0;
        int maxLength = 0;


        for(int right = 0; right < input.length(); right++) {
            char currentChar = input.charAt(right);

            if(charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                left = charIndex.get(currentChar) + 1;
            }

            charIndex.put(currentChar, right);

            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}
