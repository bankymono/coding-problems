package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem23 {
    public static void main(String[] args) {
        String input1 = "egg";
        String input2 = "add";

        System.out.println(String.format("is %s and %s isomorphic -> %s",input1,input2, stringsAreIsomorphic(input1, input2)));
    }

    public static boolean stringsAreIsomorphic(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(mapST.containsKey(sChar)){
                if(mapST.get(sChar) != tChar) {
                    return false;
                }
            }

            if(mapTS.containsKey(tChar)) {
                if(mapTS.get(tChar) != sChar){
                    return false;
                }
            }

            mapST.put(sChar, tChar);
            mapTS.put(tChar, sChar);
        }

        return true;
    }
}
