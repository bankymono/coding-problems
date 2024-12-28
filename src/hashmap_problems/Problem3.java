package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        String input = "swiss";

        System.out.println(String.format("First non repeating character is -> %s", firstNonRepeatingChar(input)));
    }

    public static char firstNonRepeatingChar(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(char ch  : input.toCharArray()){
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }

        for(char ch: input.toCharArray()){
            if(frequencyMap.get(ch) == 1){
                return ch;
            }
        }
        return '\0';
    }
}
