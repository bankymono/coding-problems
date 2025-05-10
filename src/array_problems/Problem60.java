package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem60 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAllAnagrams(s,p));
    }

    public static List<Integer> findAllAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch,0) + 1);
        }

        int winLength = p.length();
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            if(right >= winLength) {
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if(windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }

                left++;
            }



            if(pMap.equals(windowMap)) {
//                result.add(right - winLength + 1);
                result.add(left);
            }
        }

        return result;
    }
}
