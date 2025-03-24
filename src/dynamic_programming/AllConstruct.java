package dynamic_programming;

import java.util.*;

public class AllConstruct {
    private static Map<String, List<List<String>>> memo = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
//        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
//        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "boar"}));
//        System.out.println(allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
//        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef",
//                new String[]{"e",
//                        "ee",
//                        "eee",
//                        "eeee",
//                        "eeeee",
//                        "eeeeee"}));
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
//        if(memo.containsKey(target)) return memo.get(target);

        if(target.isEmpty()) {
            List<List<String>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<String>> result = new ArrayList<>();

        for(String word : wordBank) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());

                List<List<String>> temp = allConstruct(suffix, wordBank);

                if (!temp.isEmpty()) {
                    for(List<String> list : temp) {
                        list.add(word);
                    }
                }
                result.addAll(new ArrayList<>(temp));
            }
        }
//        memo.put(target, result);
        return result;
    }
}
