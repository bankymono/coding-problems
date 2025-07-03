package dynamic_programming;
import java.util.Map;
import java.util.HashMap;

public class Lc647b {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(countPalindrome(s));
    }

    public static int countPalindrome(String s) {
        int n = s.length();
        int count = 0;
        Map<String, Boolean> memo = new HashMap<>();



        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s, i, j, memo)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, int i, int j, Map<String, Boolean> memo) {
        String key = i + "|" + j;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        if(i >= j) {
            return true;
        }

        if(s.charAt(i) != s.charAt(j)) {
            memo.put(key, false);
            return false;
        }
        boolean result = isPalindrome(s, i+1, j-1, memo);

        memo.put(key, result);
        return result;
    }
}
