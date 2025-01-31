package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem48 {
    public static void main(String[] args) {
        String s = "cbaaebabaacd";
        String p = "aabc";

        System.out.println(findAllAnagrams(s, p));
    }

    public static List<Integer> findAllAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();


        for(char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int windowSize = p.length();


        for( int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(right >= windowSize) {
                char outChar = s.charAt(right - windowSize);

                windowMap.put(outChar, windowMap.get(outChar) - 1);
                if(windowMap.get(outChar) == 0) {
                    windowMap.remove(outChar);
                }
            }


            if(windowMap.equals( pMap)) {
                result.add(right - windowSize + 1);
            }
        }

        return result;
    }
}
