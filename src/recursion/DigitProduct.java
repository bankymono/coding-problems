package recursion;

public class DigitProduct {
    public static void main(String[] args) {
        System.out.println(productOfDigit(1342));
    }

    public static int productOfDigit(int n) {
        if(n == 0) {
            return 1;
        }
        return productOfDigit(n/10)  *  (n % 10);
    }
}
