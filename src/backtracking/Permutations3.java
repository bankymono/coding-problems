package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations3 {
    public static void main(String[] args) {
//        permutations("","abc");

//        System.out.println(permutationsReturnList("", "abc"));
        System.out.println(permutationsReturnCount("", "abc"));
    }

    static void permutations(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i);
            permutations(first + ch + second, up.substring(1));
        }
    }

    static List<String> permutationsReturnList(String p, String up) {
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> result = new ArrayList<>();
        char ch = up.charAt(0);


        for(int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i);
             result.addAll(permutationsReturnList(first + ch + second, up.substring(1)));
        }

        return result;
    }

    static int permutationsReturnCount(String p, String up) {
        if(up.isEmpty()) {
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);


        for(int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i);
            count += permutationsReturnCount(first + ch + second, up.substring(1));
        }

        return count;
    }
}
