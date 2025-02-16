package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem18 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWinSubString(s, t));
    }

    public static String minWinSubString(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for(char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int formed = 0;
        int required = tMap.size();
        int left = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int minStart = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(tMap.containsKey(currentChar) && tMap.get(currentChar).intValue() == windowMap.get(currentChar).intValue()){
                formed++;
            }

            while(formed == required) {
                if(right - left + 1 < minWindowSize) {
                    minWindowSize = right - left + 1;
                    minStart = left;
                }


                char leftChar = s.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if(tMap.containsKey(leftChar) && windowMap.get(leftChar)
                        < tMap.get(leftChar)){
                    formed--;
                }
                left++;
            }

        }

        return s.substring(minStart, minStart + minWindowSize);
    }
}
