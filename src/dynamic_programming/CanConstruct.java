package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    private static Map<String, Boolean> memo = new HashMap<>();
    public static void main(String[] args) {

        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "boar"}));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e",
                        "ee",
                        "eee",
                        "eeee",
                        "eeeee",
                        "eeeeee"}));
    }

    public static boolean canConstruct(String target, String[] wordBank) {
        if(memo.containsKey(target)){
            return memo.get(target);
        }

        if(target.isEmpty()){
            return true;
        }

        for(String word : wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if(canConstruct(suffix, wordBank)) {
                    memo.put(target,true);
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
    }

}
