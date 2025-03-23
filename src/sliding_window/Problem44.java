package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem44 {
    public static void main(String[] args) {
        String s = "ABABA";
        int k = 1;

        System.out.println(charReplacementMethod(s, k));        
    }

    public static int charReplacementMethod(String s, int k) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int maxFreq = 0;
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);
            maxFreq = Math.max(maxFreq, charFreq.get(currentChar));

            while((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);

                charFreq.put(leftChar, charFreq.get(leftChar) - 1);

                left++;
            }

            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}
