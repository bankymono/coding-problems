package recursion;

public class CountSteps {
    public static void main(String[] args) {
        System.out.println(countSteps(8));
    }

    public static int countSteps(int num) {
        return countSteps(num, 0);
    }

    public static int countSteps(int n, int count) {
        if(n == 0) {
            return count;
        }

        if(n%2 == 0) {
            return countSteps(n/2, count + 1);
        }

        return countSteps(n - 1, count + 1);
    }
}
