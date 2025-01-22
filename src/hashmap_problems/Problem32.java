package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem32 {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(String.format("is %s and %s isomorphic -> %s",s, t, isIsomorphic(s, t)));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character,Character> mapTS = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(mapST.containsKey(sChar)) {
                if(mapST.get(sChar) != tChar) return false;
            }

            if(mapTS.containsKey(tChar)) {
                if(mapTS.get(tChar) != sChar) return false;
            }

            mapST.putIfAbsent(sChar, tChar);
            mapTS.putIfAbsent(tChar, sChar);
        }

        return true;
    }
}
