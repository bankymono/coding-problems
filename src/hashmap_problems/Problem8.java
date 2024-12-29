package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem8 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(String.format("the indices of anagrams of %s in %s are %s", p, s, findAnagrams(s,p)));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) return result;

        Map<Character, Integer> pMap = new HashMap();
        Map<Character, Integer> windowMap = new HashMap<>();
        
        // get the characters of p
        for(int i = 0; i < p.length(); ++i){
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0) + 1);
        }

        int windowSize = pMap.size();

        for(int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);

            windowMap.put(currentChar, windowMap.getOrDefault(currentChar,0) + 1);

            if(i >= windowSize){
                char outOfWindowChar = s.charAt(i - windowSize);

                if(windowMap.get(outOfWindowChar) == 1){
                    windowMap.remove(outOfWindowChar);
                }else {
                    windowMap.put(outOfWindowChar, windowMap.get(outOfWindowChar) - 1);
                }
            }

            if(pMap.equals(windowMap)){
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}
