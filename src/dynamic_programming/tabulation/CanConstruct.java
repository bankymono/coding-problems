package dynamic_programming.tabulation;

public class CanConstruct {
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
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;

        for(int i = 0; i <= target.length(); i++) {
            if(table[i] == true) {
                for(String word : wordBank) {
                    if(target.startsWith(word, i)) {
                        table[i + word.length()]= true;
                    }
                }
            }
        }

        return table[target.length()];
    }
}
