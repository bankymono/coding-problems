package recursion.string;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(('b' - 1));
        System.out.println(letterCombination("","12"));
    }

    public static void pad(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        System.out.println();
    }

    public static List<String> letterCombination(String p, String up) {
        if(up.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);
        List<String> finalResult = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            var res = letterCombination(f + ch + s, up.substring(1));
            finalResult.addAll(res);
        }

        return finalResult;
    }
}
