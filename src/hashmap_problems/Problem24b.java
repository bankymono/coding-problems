package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem24b {
    public static void main(String[] args) {

        String input1 = "listen";
        String input2 = "silent";

        System.out.println(String.format("%s and %s are anagrams -> %s", input1, input2, isAnagram(input1, input2)));
    }

    public static boolean isAnagram(String input1, String input2) {

        Map<Character, Integer> charFreq = new HashMap<>();

        if(input1.length() != input2.length()) {
            return false;
        }

        for( int i = 0; i < input1.length(); ++i) {
            char c = input1.charAt(i);
            char s = input2.charAt(i);

            charFreq.put(c, charFreq.getOrDefault(c, 0)+1);
            charFreq.put(s, charFreq.getOrDefault(s, 0)-1);
        }

        for(int count : charFreq.values()){
            if(count != 0){
                return false;
            }
        }

        return true;
    }
}
