package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem27 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p =  "abc";
        System.out.println(String.format("start indices for anagram %s in %s -> %s", p, s, getStartIndices(s,p)));
    }

    public static List<Integer> getStartIndices(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> pFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();
        int windowSize = p.length();

        if(s.length() < p.length()) return result;

        for(int i = 0;  i < p.length(); ++i) {
            char currentChar = p.charAt(i);
             pFreq.put(currentChar, pFreq.getOrDefault(currentChar,0) + 1);
        }

        System.out.println(pFreq);

        for(int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);

            windowFreq.put(currentChar, windowFreq.getOrDefault(currentChar, 0) + 1);

            if( i >= windowSize) {
                char outChar = s.charAt(i - windowSize);

                if(windowFreq.get(outChar) == 1) {
                    windowFreq.remove(outChar);
                } else {
                    windowFreq.put(outChar, windowFreq.get(outChar) - 1);
                }

            }

            if(windowFreq.equals(pFreq)) {
                    result.add(i - windowSize + 1);
                }
        }
        return result;
    }
}
