package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem6 {
    public static void main(String[] args) {
        String s ="swiss";

        System.out.println(firstNonRepeatingChar(s));
    }

    public static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        for(char ch : s.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch,0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            if(charMap.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            } 
        }


        return '\000';
    }
}
