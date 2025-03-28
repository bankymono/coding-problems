package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem49 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(minWithouthRepeatingCharacters(input));
    }

    public static int minWithouthRepeatingCharacters(String input) {
        Map<Character, Integer> charMap = new HashMap<>();

        int result = Integer.MIN_VALUE;
        int left = 0;

        for(int right = 0; right < input.length(); right++){
            char currentChar = input.charAt(right);

            if(charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar,right);

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
