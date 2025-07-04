package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Lc17 {
    public static void main(String[] args) {
        String digits = "923";

        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        return letterCombinations("", digits);
    }

    public static List<String> letterCombinations(String p, String digit) {
        if(digit.isEmpty()) {
            List<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }
        String [] letters = {
                "",//0
                "",//1
                "abc",//2
                "def",//3
                "ghi",//4
                "jkl",//5
                "mno",//6
                "pqrs",//7
                "tuv",//8
                "wxyz"//9
        };

        List<String> result = new ArrayList<>();
        char ch = digit.charAt(0);
        int index = ch - '0';
        String strAtIndex = letters[index];
        System.out.println(strAtIndex);
        for(int i = 0; i < strAtIndex.length(); i++) {
            List<String> left = letterCombinations(p + strAtIndex.charAt(i), digit.substring(1));
            result.addAll(left);
        }
        return result;
    }
}
