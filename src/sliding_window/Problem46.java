package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem46 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWinSubstring(s, t));        
    }

    public static String minWinSubstring(String s, String t){
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int minSize = Integer.MAX_VALUE;
        int minStartIndex = 0;

        for(char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch,0) + 1);
        }
        int formed = 0;
        int required = tMap.size();
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(tMap.containsKey(currentChar) && windowMap.get(currentChar).intValue() == tMap.get(currentChar).intValue()){
                formed++;
            }

            while(formed == required) {
                if(right - left + 1 <= minSize) {
                    minStartIndex = left;
                    minSize = right - left + 1;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if(tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)){
                    formed--;
                }

                left++;
            }
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(minStartIndex, minStartIndex + minSize);
    }
}
