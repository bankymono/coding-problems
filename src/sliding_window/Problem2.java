package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minSubString(s, t));
    }

    public static String minSubString(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int left = 0;
        int formed = 0;
        int right;

        if(s.length() < t.length()) return "";

        for(char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int required = targetMap.size();

        Map<Character, Integer> windowMap = new HashMap<>();

        for( right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(targetMap.containsKey(currentChar) 
               && targetMap.get(currentChar).intValue() == windowMap.get(currentChar).intValue()){
                formed++;
            }

            while(formed == required) {
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char outChar = s.charAt(left);

                windowMap.put(outChar, windowMap.get(outChar) - 1);

                if(targetMap.containsKey(outChar) && windowMap.get(outChar).intValue() < targetMap.get(outChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minStart == Integer.MAX_VALUE ? "" : s.substring(minStart, right);
    }
}
