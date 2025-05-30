package recursion.string;

public class Ascii {
    public static void main(String[] args) {
        char ch = 'a';
        String word = "abc";
        subseqAscii("",word);
    }

    public static void subseqAscii(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subseqAscii(p + ch, up.substring(1));
        subseqAscii(p, up.substring(1));
        subseqAscii(p + (ch + 0), up.substring(1));
    }
}
