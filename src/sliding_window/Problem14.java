package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem14 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(charReplacement(s, k));
    }

    public static int charReplacement(String s, int k) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int maxFreq = 0;
        int maxLength = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);

            maxFreq = Math.max(maxFreq, charFreq.get(currentChar));

            while((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                charFreq.put(leftChar, charFreq.get(leftChar) - 1);
                if(charFreq.get(leftChar) == 0) {
                    charFreq.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
