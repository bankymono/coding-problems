package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem12 {
    public static void main(String[] args) {
        String input1 = "egg";
        String input2 = "add";

        System.out.println(String.format("are %s and %s isomorph? -> %s",input1, input2, areIsomorphs(input1, input2)));
    }

    public static boolean areIsomorphs(String s, String t) {
        Map<Character,Character> charST = new HashMap<>();
        Map<Character,Character> charTS = new HashMap<>();

        if(charST.size() != charTS.size()){
            return false;
        }

        for(int i = 0; i < s.length(); ++i){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(charST.containsKey(sChar)){
                if(charTS.get(tChar) != sChar){
                    return false;
                }
            } else {
                charST.put(sChar, tChar);
            }

            if(charTS.containsKey(tChar)){
                if(charST.get(sChar) != tChar){
                    return false;
                }
            } else {
                charTS.put(tChar, sChar);
            }
        }

        return true;
    }
}
