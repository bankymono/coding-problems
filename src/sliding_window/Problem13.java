package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem13 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubString(s));
    }

    public static int longestSubString(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int longest = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if(charMap.containsKey(currentChar) && left <= charMap.get(currentChar)){
                left = charMap.get(currentChar) + 1;
            }

            

            charMap.put(currentChar, right);

            longest = Math.max(right - left + 1, longest);
        }

        return longest;
    }
}
