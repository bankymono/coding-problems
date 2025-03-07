package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem27 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        System.out.println(longestAtMostK(s,k));
    }

    public static String longestAtMostK(String s, int k){
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        int maxSize = 0;
        int startIndex = 0;

        for(int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            charMap.put(currentChar, charMap.getOrDefault(currentChar, 0) + 1);

            while(charMap.size() > k) {
                char leftChar = s.charAt(left);

                charMap.put(leftChar, charMap.get(leftChar) - 1);
                if(charMap.get(leftChar) == 0){
                    charMap.remove(leftChar);
                }

                left++;
            }

            if(right - left + 1 >= maxSize) {
                maxSize = right - left + 1;
                startIndex = left;
            }
           
        }



        return s.substring(startIndex, startIndex + maxSize);
    }
}
