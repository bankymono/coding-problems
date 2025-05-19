package recursion.string;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String s = "abc";
//        permutations("",s);
//        System.out.println(permutationsRet("", s));
        System.out.println(permutationsCount("", s));
    }

    public static void permutations(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);

            permutations(f + ch + s, up.substring(1));
        }


    }

    public static List<String> permutationsRet(String p, String up) {
        if(up.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        List<String> res = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);

            var ans = permutationsRet(f + ch + s, up.substring(1));
            res.addAll(ans);
        }

        return res;
    }


    public static int permutationsCount(String p, String up) {
        if(up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);

            count = count + permutationsCount(f + ch + s, up.substring(1));
        }

        return count;

    }

}
