package dynamic_programming;

public class Lc91 {
    public static void main(String[] args) {
//        String secret= "11106";
        String secret= "06";
        System.out.println(decodeWays(secret));
    }

    public static int decodeWays(String secret) {

        return decodeWays(0, secret);
    }

    public static int decodeWays(int index, String secret) {

        if(index == secret.length() - 1){
            return 1;
        }

        if(index >= secret.length() - 1) {
            return 0;
        }

//        for(int i = 0; i < secret.length(); i++) {
//            String suffix = secret.substring(secret.charAt(i));
//
//        }
         int selected = decodeWays(index + 1, secret);
         int notSelected = decodeWays(index + 1, secret);


         return  selected + notSelected;


    }
}
