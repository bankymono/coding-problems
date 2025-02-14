package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem21 {
    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";

        System.out.println(areValidAnagrams(input1, input1));
    }

    public static boolean areValidAnagrams(String input1, String input2) {
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < input1.length(); i++) {
            char charA = input1.charAt(i);
            char charB = input2.charAt(i);

            charMap.put(charA, charMap.getOrDefault(charA, 0) + 1);
            charMap.put(charB, charMap.getOrDefault(charB, 0) - 1);
        }

        for(int ch : charMap.values()) {
            if(ch != 0) return false;
        }

        return true;
    }
}
