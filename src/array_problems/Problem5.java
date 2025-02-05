package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem5 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        
        System.out.println(allAnagram(s,p));
    }

    public static List<Integer> allAnagram(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character,Integer> windowMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int windowSize = p.length();

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);


            if(right >= windowSize) {
                char outChar = s.charAt(right - windowSize);

                if(windowMap.get(outChar) == 1) {
                    windowMap.remove(outChar);
                } else {
                    windowMap.put(outChar, windowMap.get(outChar) -1);
                }
            }

            if(pMap.equals(windowMap)) {
                result.add(right - windowSize + 1);
            }
        }
        return result;
    }
}
