package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem56 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        System.out.println(longestSubstringMostK(s, k));
    }

    public static int longestSubstringMostK(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxCount = Integer.MIN_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            charMap.put(currentChar, charMap.getOrDefault(currentChar, 0) + 1);

            while(charMap.size() > k) {
                char leftChar = s.charAt(left);

                charMap.put(leftChar, charMap.get(leftChar) -1);

                if(charMap.get(leftChar) == 0) {
                    charMap.remove(leftChar);
                }

                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }


}
