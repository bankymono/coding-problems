package recursion.string;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
//        System.out.println(('b' - 1));
//        System.out.println(letterCombination("","12"));
//        pad("","23");
        System.out.println(letterCombination("","23"));
    }

    public static void pad(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for(int i = (digit - 2) * 3; i < ((digit - 1) * 3); i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }

    }

    public static List<String> letterCombination(String p, String up) {
        if(up.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        int digit = up.charAt(0) - '0';
        List<String> result = new ArrayList<>();

        for(int i = (digit - 2) * 3; i < ((digit - 1) * 3); i++) {
            char ch = (char) ('a' + i);
            var ans = letterCombination(p + ch, up.substring(1));
           result.addAll(ans);
        }

        return result;
    }
}
