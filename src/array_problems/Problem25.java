package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem25 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(smallestWindow(s, t));        
    }

    public static String smallestWindow(String s, String t) {
        
        int formed = 0;
        int left = 0;
        int right  = 0;

        Map<Character, Integer> wMap = new HashMap<>();

        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0) + 1);
        }

        int required = tMap.size();
        int minSize = Integer.MAX_VALUE;
        int minStart = 0;

       for(right = 0; right < s.length(); right++) {
        char currentChar = s.charAt(right);
        wMap.put(currentChar, wMap.getOrDefault(currentChar,0) + 1);

        if(tMap.containsKey(currentChar) && tMap.get(currentChar).intValue() == wMap.get(currentChar).intValue()){
            formed++;
        }

        while(formed == required) {
            if(right - left + 1 < minSize) {
                minSize = right - left + 1;
                minStart = left;
            }
            char leftChar = s.charAt(left);

            wMap.put(leftChar, wMap.get(leftChar) - 1);


            left++;

            if(tMap.containsKey(leftChar) && wMap.get(leftChar) < tMap.get(leftChar)){
                formed--;
            }
            
            if(wMap.get(leftChar) == 0){
                wMap.remove(leftChar);
            }
        }
       }

       return minSize == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minSize);
    }
}
