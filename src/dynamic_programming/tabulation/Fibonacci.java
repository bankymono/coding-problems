package dynamic_programming.tabulation;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {

        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
    }

    public static long fib(int n) {
        long[] table = new long[n + 1];
        table[1] = 1;
        for(int i = 0; i < n; i++){
            table[i + 1] += table[i];
            if(i + 2 <= n){
                table[i + 2] += table[i];
            }
        }


//        System.out.println(Arrays.toString(table));
        return table[n];
    }

}
