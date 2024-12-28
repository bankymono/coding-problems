package array_problems;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    public static void main(String[] args) {
        // String s = "abcabcbb";
        String s = "abcedcwxyasf";

        System.out.println(String.format("string -> %s, output -> %s", s, lengthOfLongestSubstring(s)));   
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for(int right=0; right < s.length(); ++right){
            Character c = s.charAt(right);

            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
