package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LCS {
    public static void main(String[] args) {

        String text1 = "abcbd";
        String text2 = "efgcdabd";

        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return longestCommonSubsequence(m, n, word1, word2, new HashMap<>());
    }

    public static int longestCommonSubsequence(int m, int n, String word1, String word2, Map<String, Integer> memo) {
        String key = m + "," + n;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(m == 0 || n == 0) {
            return 0;
        }

        int result;
        if(word1.charAt(m - 1) == word2.charAt(n - 1)) {
            result = 1 + longestCommonSubsequence(m - 1, n - 1, word1, word2, memo);
        } else {
            result = Math.max(longestCommonSubsequence(m, n - 1, word1, word2, memo),
                    longestCommonSubsequence(m-1, n , word1, word2, memo));
        }

        memo.put(key, result);

        return result;
    }
}
