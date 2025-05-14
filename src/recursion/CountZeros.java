package recursion;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZeros(302004));
    }

    public static int countZeros(int num) {
        return countZeros(num, 0);
    }

    public static int countZeros(int num, int count) {
        if(num == 0) {
//            if(num == 0) {
//                return count + 1;
//            }
            return count;
        }

        if(num % 10 == 0) {
            return countZeros(num/10, count + 1);
        }

        return countZeros(num/10, count);
    }
}
