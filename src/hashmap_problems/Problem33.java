package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem33 {
    public static void main(String[] args) {
        String input = "abcabcbb";

        System.out.println(String.format("longest sub string length is -> %s", longestSubstring(input)));
    }

    public static int longestSubstring(String input) {
        Map<Character, Integer> indexHolder = new HashMap<>();
        int maxLength = 0;
        int left = 0;


        for(int right = 0; right < input.length(); ++right) {
            char ch = input.charAt(right);

            if(indexHolder.containsKey(ch)) {
                left = Math.max(left, indexHolder.get(ch) + 1);
            }

            indexHolder.put(ch, right);

            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}
