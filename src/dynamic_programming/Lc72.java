package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Lc72 {
    public static void main(String[] args) {
        String word1 ="dinitrophenylhydrazine";
        String word2 = "benzalphenylhydrazone";

        System.out.println(minDistance(word1,word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return minDistance(m,n, word1, word2, new HashMap<>());
    }
    public static int minDistance(int m, int n, String word1, String word2, Map<String, Integer> memo) {
        String key = m + "," + n;
        if(memo.containsKey(key)) return memo.get(key);
        if(m == 0) {
            return n;
        }
        if(n == 0) {
            return m;
        }

        int res;

        if(word1.charAt(m - 1) == word2.charAt(n - 1)) {
            res = minDistance(m -1, n-1, word1, word2, memo);
        } else {
            int op1 = minDistance(m-1, n-1, word1,word2, memo);
            int op2 = minDistance(m-1, n, word1,word2, memo);
            int op3 = minDistance(m, n-1, word1,word2, memo);
            res = Math.min(op1, Math.min(op2,op3)) + 1;
        }

        memo.put(key, res);

        return res;
    }
}
