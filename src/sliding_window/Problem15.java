package sliding_window;

import java.util.List;

public class Problem15 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(longestStringWithVowel(s,k));
    }

    public static int longestStringWithVowel(String s, int k){
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int maxVowels = 0;
        int vowelCount = 0;

        for(int i = 0; i < k; i++) {
            char currentChar = s.charAt(i);

            if(vowels.contains(currentChar)){
                ++vowelCount;
            }
            maxVowels = Math.max(vowelCount, maxVowels);
        }

        for(int i = k; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            char outChar = s.charAt(i - k);

            if(vowels.contains(currentChar)){
                ++vowelCount;
            }

            if(vowels.contains(outChar)){
                --vowelCount;
            }

            maxVowels = Math.max(vowelCount, maxVowels);
        }

        return maxVowels;
    }
}
