package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem46 {
    public static void main(String[] args) {
        String input1 = "listen"; 
        String input2 = "silenr";

        System.out.println(validAnagrams(input1, input2));        
    }

    public static boolean validAnagrams(String input1, String input2){
        Map<Character, Integer> chMap = new HashMap<>();

        for(char ch : input1.toCharArray()) {
            chMap.put(ch,chMap.getOrDefault(ch, 0) + 1);
        }

        for(char ch : input2.toCharArray()) {
            chMap.put(ch,chMap.getOrDefault(ch, 0) - 1);
        }

        for(int value : chMap.values()){
            if(value != 0) {
                return false;
            }
        }

        return true;
    }
}
