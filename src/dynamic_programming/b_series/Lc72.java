package dynamic_programming.b_series;

import java.util.HashMap;
import java.util.Map;

public class Lc72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(editDistance(word1,word2));
    }

    public static int editDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return editDistance(word1, word2, m, n, new HashMap<>());
    }

    public static int editDistance(String word1, String word2, int m, int n, Map<String, Integer> memo) {
        String key = m + "|" + n;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(m == 0){
            return n;
        }

        if(n == 0){
            return m;
        }

        int min = 0;

        if(word1.charAt(m - 1) == word2.charAt(n - 1)) {
            min = editDistance(word1, word2, m - 1, n - 1, memo);
        } else {
            int opOne = editDistance(word1, word2, m - 1, n, memo);
            int opTwo = editDistance(word1, word2, m, n - 1, memo);
            int opThree = editDistance(word1, word2, m - 1, n - 1, memo);

            min = Math.min(opOne, Math.min(opThree, opTwo)) + 1;
        }

        memo.put(key, min);

        return min;
    }
}
