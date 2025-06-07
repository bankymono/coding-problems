package dynamic_programming.b_series;

import java.util.HashMap;
import java.util.Map;

public class Lc97 {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(isInterleave(s1,s2,s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1,s2,s3,0,0,new HashMap<>());
    }

    public static boolean isInterleave(String s1, String s2, String s3, int i, int j, Map<String, Boolean> memo) {
        String key = i + "|" + j;

        int k = i + j;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(k == s3.length()) {
            return true;
        }

        boolean isValid = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isValid = isInterleave(s1,s2,s3, i+1, j, memo);
        }

        if(!isValid && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isValid = isInterleave(s1,s2,s3,i,j+1, memo);
        }

        memo.put(key, isValid);

        return isValid;
    }
}
