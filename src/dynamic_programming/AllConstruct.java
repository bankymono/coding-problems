package dynamic_programming;

import java.util.*;

public class AllConstruct {
//    private static final Map<String, List<List<String>>> memo = new HashMap<>();
    public static void main(String[] args) {
        Map<String, List<List<String>>> memo = new HashMap<>();
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, memo));
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd","ef", "c"}, memo));
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "boar"}, memo));
        System.out.println(allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, memo));
        System.out.println(allConstruct("eeeeeeeef",
                new String[]{"e",
                        "ee",
                        "eee",
                        "eeee",
                        "eeeee",
                        "eeeeee"}, memo));
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> memo) {
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
                List<List<String>> prevResult = allConstruct(suffix, wordBank, memo);

                if (!prevResult.isEmpty()) {
                    List<List<String>> tempHolder = new ArrayList<>();
                    for(List<String> innerList : prevResult) {
                        List<String> list = new ArrayList<>();
                        list.add(word);
                        list.addAll(innerList);
                        tempHolder.add(list);
                    }
                    result.addAll(tempHolder);
                }
            }
        }
//        memo.put(target, new ArrayList<>(result));
        return result;
    }
}
