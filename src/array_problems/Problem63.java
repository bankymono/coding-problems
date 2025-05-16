package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem63 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(findInString(s, t));
    }

    public static String findInString(String s, String t){
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for(char ch : t.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int required = pMap.size();

        int formed = 0;

        int left = 0;
        int minSize = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(pMap.containsKey(currentChar) && pMap.get(currentChar).intValue() == windowMap.get(currentChar).intValue()) {
                formed++;
            }

            while(formed == required) {
                char leftChar = s.charAt(left);
                if(right - left + 1 < minSize) {
                    minSize = right - left + 1;
                    startIndex = left;
                }

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if(pMap.containsKey(leftChar) && windowMap.get(leftChar) < pMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }
        
        return minSize == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minSize);
    }
}
