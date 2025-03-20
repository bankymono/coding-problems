package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem40 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        System.out.println(longestSubStringMostK(s, k));   
    }

    public static int longestSubStringMostK(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int smallestLength = Integer.MIN_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charMap.put(currentChar, charMap.getOrDefault(currentChar, 0) + 1);

            while(charMap.size() > k) {
                char leftChar = s.charAt(left);

                charMap.put(leftChar, charMap.get(leftChar) - 1);
                if(charMap.get(leftChar) == 0) {
                    charMap.remove(leftChar);
                }

                left++;
            }

            smallestLength = Math.max(smallestLength, right - left + 1);
        }
        return smallestLength;
    }
}
