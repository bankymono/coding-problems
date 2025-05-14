package recursion;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(isPalindrome("issi"));
    }

    public static boolean isPalindrome(String word) {
        return word.equals(reverse(word));
    }

    public static String reverse(String word) {
        if(word.isEmpty()) {
            return "";
        }
        return word.substring(word.length() - 1) + reverse(word.substring(0,word.length() - 1));
    }
}
