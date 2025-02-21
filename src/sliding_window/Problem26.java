package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem26 {
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(longestStringWithoutRepeating(s));
    }

    public static int longestStringWithoutRepeating(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int longest = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if(charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left){
                left = charIndex.get(currentChar) + 1;
            }

            charIndex.put(currentChar, right);


            longest = Math.max(longest, right - left + 1);
        }


        return longest;

    }
}
