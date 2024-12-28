package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem5 {
    public static void main(String[] args) {
        String input = "abcabcbb";

        System.out.println(String.format("length of substring -> %s", longestSubStringWithoutRepeatingChar(input)));
    }

    public static int longestSubStringWithoutRepeatingChar(String input){
        int left = 0;
        int longestLength = 0;
        Map<Character, Integer> tracker = new HashMap<>();

        for(int right = 0; right < input.length(); ++right) {
            char ch = input.charAt(right);

            if(tracker.containsKey(ch)){
                left = Math.max(left, tracker.get(ch)+1);
            }

            tracker.put(ch, right);
            longestLength = Math.max(longestLength, right - left + 1);
            
        }

        return longestLength;
    }
}
