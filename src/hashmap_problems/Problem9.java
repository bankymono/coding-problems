package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem9 {
    public static void main(String[] args) {
        String input = "swwiiss";
        System.out.println(firstNonRepeatedChar(input));
    }

    public static char firstNonRepeatedChar(String input) {

        Map<Character,Integer> charMap = new HashMap<>();

        for(char ch : input.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch, 0) +1);
        }

        for(int i = 0; i < input.length(); ++i){
            char st = input.charAt(i);
            if(charMap.get(st) == 1) {
                return st;
            }
        }

        return '\0';
    }
}
