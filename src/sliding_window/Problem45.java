package sliding_window;

import java.util.List;

public class Problem45 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        System.out.println(maxVowelSub(s, k));
    }

    public static int maxVowelSub(String s, int k){
        List<Character> vowels = List.of('a','e','i','o','u');
        int maxVowel ;
        int windowVowelCount = 0;

        for(int i = 0; i < k; i++) {
            char currentChar = s.charAt(i);
            if(vowels.contains(currentChar)){
                windowVowelCount++;
            }
        }

        maxVowel = windowVowelCount;

        for(int i = k; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            char outChar = s.charAt(i - k);
            if(vowels.contains(outChar)){
                windowVowelCount--;
            }
            if(vowels.contains(currentChar)){
                windowVowelCount++;
            }

            maxVowel = Math.max(maxVowel, windowVowelCount);
        }

        return maxVowel;
    }
}
