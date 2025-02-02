package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstringNoRepeat(s));
    }

    public static int longestSubstringNoRepeat(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if(charMap.containsKey(ch) && charMap.get(ch) >= left) {
                left = charMap.get(ch) + 1;
            }

            charMap.put(ch, right);

            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}
