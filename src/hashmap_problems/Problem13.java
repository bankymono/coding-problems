package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem13 {
    public static void main(String[] args) {
        String input = "abcabcbb";

        System.out.println(String.format("lenght of longest sub -> %s", longestSubStr(input)));
    }

    public static int longestSubStr(String input) {
        Map<Character, Integer> charMap = new HashMap<>();
        int result = 0;

        int left = 0;

        for (int right = 0; right < input.length(); ++right){
            char currentChar = input.charAt(right);

            if(charMap.containsKey(currentChar)){
                left = Math.max(left, charMap.get(currentChar) + 1);
            }
            
            charMap.put(currentChar, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
