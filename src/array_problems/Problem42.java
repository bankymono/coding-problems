package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem42 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(validAnagrams(s, p));
    }

    public static List<Integer> validAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for(char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int k = p.length();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(i>= k) {
                char outChar = s.charAt(i - k);

                windowMap.put(outChar, windowMap.get(outChar) - 1);

                if(windowMap.get(outChar) == 0) {
                    windowMap.remove(outChar);
                }
            }


            if(windowMap.equals(pMap)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}
