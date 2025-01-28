package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        String s ="abcabcbb";
        System.out.println(longestSubString(s));
    }

    public static int longestSubString(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int longestStr = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if(charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            longestStr = Math.max(longestStr, right - left + 1);


            charMap.put(currentChar, right);
        }

        return longestStr ;

    }
}
