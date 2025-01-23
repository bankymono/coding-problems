package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem36 {
    public static void main(String[] args) {
       String s = "cbaebabacd";
       String p = "abc";

       System.out.println(String.format("the indices of the anagram -> %s", allAnagrams(s, p)));
    }

    public static List<Integer> allAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int windowSize = p.length();
        List<Integer> result = new ArrayList<>();

        for(char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }


        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            windowMap.put(ch, windowMap.getOrDefault(ch,0) + 1);


            if(i >= windowSize) {
                char outChar = s.charAt(i - windowSize);
                if(windowMap.get(outChar) == 1) {
                    windowMap.remove(outChar);
                } else {
                    windowMap.put(outChar, windowMap.get(outChar) - 1);
                }

            }

            if(pMap.equals(windowMap)) {
                result.add(i - windowSize + 1);
            }
        }

        return  result;
    }
}
