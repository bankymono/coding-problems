package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem35 {
    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";
        System.out.println(validAnagram(input1, input2));
    }

    public static boolean validAnagram(String input1, String input2) {
        Map<Character, Integer> charMap = new HashMap<>();

        if(input1.length() != input2.length()) return false;

        for(int i = 0; i < input1.length(); i++) {
            char currentChar = input1.charAt(i);
            char currentChar2 = input2.charAt(i);
            charMap.put(currentChar,charMap.getOrDefault(currentChar,0) + 1);
            charMap.put(currentChar2,charMap.getOrDefault(currentChar2,0) - 1);
        }

        for(Integer value : charMap.values()){
            if(value != 0) return false;
        }

        return true;
    }
}
