package recursion.string;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
        String word = "abc";

        List<String> result = new ArrayList<>();
        System.out.println(subseq2("", word));
    }

    public static void subseq(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    public static List<String> subseq2(String p, String up) {
        if(up.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);

        List<String> r1= subseq2(p + ch, up.substring(1));
        List<String> r2= subseq2(p, up.substring(1));

        List<String> res = new ArrayList<>();

        res.addAll(r1);
        res.addAll(r2);

        return res;
    }
}
