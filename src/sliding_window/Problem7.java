package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem7 {
    public static void main(String[] args) {
        String s = "aa";
        int k = 1;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> windowMap = new HashMap<>();
        int maxDistincChar = 0;
        int result = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            while(windowMap.size() > k) {
                windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);

                if(windowMap.get(s.charAt(left)) == 0) {
                    windowMap.remove(s.charAt(left));
                }

                left++;
            }

            maxDistincChar = Math.max(right - left + 1, maxDistincChar);
        }

        return  maxDistincChar;
    }
}
