package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";
        System.out.println(validAnagram(input1, input2));   
    }

    public static boolean validAnagram(String input1, String input2) {
        Map<Character, Integer> charMap = new HashMap<>();

        for(char ch : input1.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for(char ch : input2.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) - 1);
        }

        for(int val : charMap.values()) {
            if(val != 0) return false;
        }
        
        return true;
    }
}
