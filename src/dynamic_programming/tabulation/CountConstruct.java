package dynamic_programming.tabulation;

public class CountConstruct {
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
        int[] table = new int[target.length() + 1];
        table[0] = 1;
        for(int i = 0; i <= target.length(); i++) {
            for(String word : wordBank) {
                if(target.startsWith(word, i)) {
                    table[i + word.length()] += table[i];
                }
            }
        }

        return table[target.length()];
    }
}
