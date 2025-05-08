package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem58 {
    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";

        System.out.println(isAnagram(input1, input2));
    }

    public static boolean isAnagram(String input1, String input2) {
        if(input1.length() != input2.length()) {
            return false;
        }

        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < input1.length(); i++) {
            char char1 = input1.charAt(i);
            char char2 = input2.charAt(i);

            charMap.put(char1, charMap.getOrDefault(char1, 0) + 1);
            charMap.put(char2, charMap.getOrDefault(char2, 0) - 1);
        }

        for(int val : charMap.values()) {
            if(val != 0) {
                return false;
            }
        }



        return true;
    }

}
