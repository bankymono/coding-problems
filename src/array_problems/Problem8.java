package array_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem8 {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        System.out.println(areIsomorphs(s,t));
    }

    public static boolean areIsomorphs(String s, String p) {

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> pMap = new HashMap<>();

        if(s.length() != p.length()) return false;

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char pChar = p.charAt(i);

            if(sMap.containsKey(sChar)){
              if(sMap.get(sChar) != pChar) return false;
            } else {
                sMap.put(sChar, pChar);
            }

            if(pMap.containsKey(pChar)){
              if(pMap.get(pChar) != sChar) return false;
            } else {
                pMap.put(pChar, sChar);
            }
        }

        return true;
    }
}
