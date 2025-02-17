package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem20 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(allAnagrams(s, p));    
    }


    public static List<Integer> allAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int windowSize = p.length();

        for(char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);


            if(right >= windowSize) {
                char outChar = s.charAt(right - windowSize);

                windowMap.put(outChar, windowMap.get(outChar) - 1);

                if(windowMap.get(outChar) == 0) {
                    windowMap.remove(outChar);
                }
            }

            if(pMap.equals(windowMap)) {
                    result.add(right - windowSize + 1);
            }

        }

        return result;
    }


}
