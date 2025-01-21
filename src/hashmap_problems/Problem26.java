package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem26 {
    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";
        System.out.println(String.format("%s and %s are valid anagrams -> %s",input1,input2, areValidAnagrams(input1, input2)));
        
    }

    public static boolean areValidAnagrams(String input1, String input2) {
        Map<Character, Integer> anagramCheck = new HashMap<>();

        if(input1.length() != input2.length()) {
            return false;
        }


        for(int i = 0; i < input1.length(); i++) {
            char ch1 = input1.charAt(i);
            char ch2 = input2.charAt(i);

            anagramCheck.put(ch1, anagramCheck.getOrDefault(ch1,0) + 1);
            anagramCheck.put(ch2, anagramCheck.getOrDefault(ch2,0) - 1);
        }

        for(int value: anagramCheck.values()){
            if(value != 0) {
                return false;
            }
        }

        return true;
    }
}
