package hashmap_problems;

import java.util.Arrays;

public class Problem6 {
    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "silent";

        System.out.println(String.format("%s and %s comparisons as anagram has %s",input1,input2, bothAnagrams(input1, input2)));
    }

    public static boolean bothAnagrams(String input1, String input2) {
        char[] wordOneChars = input1.toCharArray();
        Arrays.sort(wordOneChars);
        String sortedWordOne = new String(wordOneChars);

        char[] wordTwoChars = input2.toCharArray();
        Arrays.sort(wordTwoChars);
        String sortedWordTwo = new String(wordTwoChars);

        return sortedWordOne.equals(sortedWordTwo);
    }
}
