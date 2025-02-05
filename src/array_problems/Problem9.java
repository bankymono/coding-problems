package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem9 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWinSubString(s, t));        
    }

    public static String minWinSubString(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int formed = 0;
        int left = 0;
        int leftStart = 0;
        int smallest = Integer.MAX_VALUE;

        for(char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int required = tMap.size();

        for(int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar,0) + 1);

            if(tMap.containsKey(currentChar)) {
                if(windowMap.get(currentChar).intValue() == tMap.get(currentChar).intValue()) {
                    formed++;
                }
            }


            while(formed == required) {
                if(right - left + 1 < smallest){
                    smallest = right - left + 1;
                    leftStart = left;
                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if(tMap.containsKey(leftChar)){
                    if(windowMap.get(leftChar) < tMap.get(leftChar)) {
                        formed--;
                    }
                }
                left++;
            }
        }

        return smallest == Integer.MAX_VALUE ? "" : s.substring(leftStart, leftStart + smallest);
    }
}
