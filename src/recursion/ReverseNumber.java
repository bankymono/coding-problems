package recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(1234));
    }

    static int sum = 0;

    public static int reverse(int num){
        return rev2(num);
    }

    public static int rev2(int num) {
        int digits = (int) Math.log10(num) + 1;

        return helper(num, digits);
    }

    public static int helper(int num, int digits) {
        if(num % 10 == num) {
            return  num;
        }
        return (num % 10) * ((int) Math.pow(10, digits-1)) + helper(num/10, digits - 1);
    }

//    public static void rev1 (int n) {
//        if(n == 0){
//            return;
//        }
//
//        int rem = n % 10;
//
//        sum = sum * 10 + rem;
//        rev1(n/10);
//    }


//    public static String reverse(int n){
//        if(n % 10 == n) {
//            return "" + n;
//        }
//
//        return n%10 + reverse(n/10);
//    }

}
