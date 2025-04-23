package sliding_window;

import java.util.List;

public class Problem54 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        System.out.println(maximumVowels(s, k));        
    }

    public static int maximumVowels(String s, int k) {
        List<Character> vowels = List.of('a','e','i','o','u');
        int maxVowels = Integer.MIN_VALUE;
        int vowelCount = 0;

        for(int i = 0; i < k; i++) {
            if(vowels.contains(s.charAt(i))){
                vowelCount++;
            }
        }
        maxVowels = Math.max(maxVowels, vowelCount);

        for(int i = k; i < s.length(); i++) {
            char outChar = s.charAt(i - k);
            if(vowels.contains(outChar)) {
                vowelCount--;
            }

            if(vowels.contains(s.charAt(i))) {
                vowelCount++;
            }

            maxVowels = Math.max(vowelCount, maxVowels);
        }

        return maxVowels;
    }
}
