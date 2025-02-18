package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem21 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(longestMostK(s, k));
    }

    public static int longestMostK(String s, int k) {
        Map<Character, Integer> cMap = new HashMap<>();
        int left = 0;
        int longestSub = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            cMap.put(currentChar, cMap.getOrDefault(currentChar, 0) + 1);

            while(cMap.size() > k) {
                char leftChar = s.charAt(left);
                cMap.put(leftChar, cMap.get(leftChar) - 1);

                if(cMap.get(leftChar) == 0) {
                    cMap.remove(leftChar);
                }

                left++;
            }

            longestSub = Math.max(longestSub, right - left + 1);
        }

        return longestSub;
    }
}
