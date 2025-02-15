package dynamic_programming;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
    }

    public static long fib(int n) {
        if(n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
