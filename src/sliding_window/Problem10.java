package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem10 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        System.out.println(subStrinkMostK(s, k));
    }

    public static int subStrinkMostK(String s, int k) {
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int longestlength = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            while(windowMap.size() > k) {
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if(windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }
                left++;
            }

            longestlength = Math.max(longestlength, right - left + 1);
        }

        return longestlength;
    }
}
