package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
    private static Map<String, Integer> memo = new HashMap<>();
    public static void main(String[] args) {

            System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
            System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
            System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "boar"}));
            System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
            System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef",
                    new String[]{"e",
                            "ee",
                            "eee",
                            "eeee",
                            "eeeee",
                            "eeeeee"}));
    }

    public static int countConstruct(String target, String[] wordBank) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()){
            return 1;
        }
        int count = 0;
        for(String word : wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                 count = count + countConstruct(suffix, wordBank);
            }
        }

        memo.put(target, count);
        return count;
    }
}