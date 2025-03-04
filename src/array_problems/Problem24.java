package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem24 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findValidAnagram(s,p));
    }

    public static List<Integer> findValidAnagram(String s, String p) {
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < p.length();i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i),0) + 1);
        }

        int windowSize = pMap.size();

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(i >= windowSize){
                char outChar = s.charAt(i - windowSize);

                windowMap.put(outChar, windowMap.get(outChar) - 1);

                if(windowMap.get(outChar) == 0) {
                    windowMap.remove(outChar);
                }
            }

            if(windowMap.equals(pMap)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}
