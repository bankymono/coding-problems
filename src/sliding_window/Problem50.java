package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem50 {
    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";

        System.out.println(validAnagrams(input1, input2));
    }

    public static boolean validAnagrams(String input1, String input2){
        if(input1.length() != input2.length()) return false;
        Map<Character, Integer> charMap = new HashMap<>();

        for(char ch : input1.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }


        for(char ch : input2.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) - 1);

            if(charMap.get(ch) < 0) {
                return false;
            }
        }

        return true;
    }
}
