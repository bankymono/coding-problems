package dynamic_programming;

public class Lc97 {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(isInterleave(s1,s2,s3));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        String s4 = merge(s3, s2);
        return true;
    }

    public static String merge(String s1, String s2) {
        String output = "";
        if(s1.length() <= s2.length()) {
            for(int i = 0; i < s1.length(); i++) {
                output += "" + s1.charAt(i) + s2.charAt(i);
            }
            for(int j = s1.length(); j < s2.length(); j++) {
                output += "" + s2.charAt(j);
            }

        } else {
            for(int i = 0; i < s2.length(); i++) {
                output += "" + s1.charAt(i) + s2.charAt(i);
            }
            for(int j = s2.length(); j < s1.length(); j++) {
                output += "" + s1.charAt(j);
            }
        }

        System.out.println(output);

        return output;
    }
}
