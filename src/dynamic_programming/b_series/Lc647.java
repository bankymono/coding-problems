package dynamic_programming.b_series;

import java.util.Map;
import java.util.HashMap;

public class Lc647 {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(countSubstrings(s)   );
    }

    public static int countSubstrings(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        int count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s,i,j, memo)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, int left, int right, Map<String , Boolean> memo){
        String key = left + "|" + right;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(left >= right) {
            return true;
        }

        if(s.charAt(left) != s.charAt(right)) {
            memo.put(key, false);
            return false;
        }

        boolean result = isPalindrome(s, left+1, right-1, memo);
        memo.put(key, result);
        return result;
    }
}
