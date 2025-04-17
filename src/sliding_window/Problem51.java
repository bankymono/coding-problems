package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem51 {
    public static void main(String[] args) {
        String s = "abcabcbb"; 
        System.out.println(longestSubstringWithoutRepeatingCharacters(s));       
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s){
        Map<Character, Integer> charMap = new HashMap<>();

        int left = 0;

        int longest = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if(charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar, right);

            longest = Math.max(right - left + 1, longest);
        }

        return longest;
    }
}
