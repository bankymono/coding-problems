package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem42 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(allAnagrams(s,p));
    }

    public static List<String> allAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character,Integer> windowMap = new HashMap<>();

        List<String> result = new ArrayList<>();

        for(char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch,0) + 1);
        }

        int windowSize = pMap.size();


        for(int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(i >= windowSize) {
                char outChar = s.charAt(i - windowSize);
                if(windowMap.get(outChar) == 1) {
                    windowMap.remove(outChar);
                } else {
                    windowMap.put(outChar, windowMap.get(outChar) - 1);
                }
            }


            if(pMap.equals(windowMap)){
                result.add(s.substring(i - windowSize + 1, i + 1));
            }


        }

        return result;
    }
}
