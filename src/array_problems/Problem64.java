package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem64 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(mostDistinct(s,k));
    }


    public static int mostDistinct(String s, int k) {
        Map<Character, Integer> winMap = new HashMap<>();
        int left = 0;
        int longestLength = Integer.MIN_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            winMap.put(ch, winMap.getOrDefault(ch,0) + 1);

            while(winMap.size() > k) {
                char leftChar = s.charAt(left);
                winMap.put(leftChar, winMap.get(leftChar) - 1);
                if(winMap.get(leftChar) == 0) {
                    winMap.remove(leftChar);
                }

                left++;

            }

            longestLength = Math.max(longestLength, right - left + 1);
        }

        return longestLength;
    }


}
