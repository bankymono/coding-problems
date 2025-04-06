package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem46 {
    public static void main(String[] args) {
     String s = "eceba";
     int k = 2;

     System.out.println(kMostElements(s, k));   
    }

    public static int kMostElements(String s, int k) {
        int longest = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            while(windowMap.size() > k) {
                char leftChar = s.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if(windowMap.get(leftChar) == 0){
                    windowMap.remove(leftChar);
                }

                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
