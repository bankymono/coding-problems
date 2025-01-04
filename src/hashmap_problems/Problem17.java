package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem17 {
    public static void main(String[] args) {
        String input = "swiss";

        System.out.println(String.format("string -> %s, ans -> %s", input, firstNonDuplicate(input)));
    }

    public static char firstNonDuplicate(String input){
        Map<Character, Integer> charMap = new HashMap<>();

        for(char ch : input.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch, 0)+1);
        }

        for(char ch : input.toCharArray()){
            if(charMap.get(ch) == 1){
                return ch;
            }
        }

        return '\0';
    }
}
