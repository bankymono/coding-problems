package dynamic_programming;

public class CountingChange {
    public static void main(String[] args) {
        System.out.println(countingChange(4, new int[]{1, 2, 3}));
//        System.out.println(countingChange(5, new int[]{1, 2, 3, 4}));
//        System.out.println(countingChange(15, new int[]{7, 7, 7}));
    }

    public static int countingChange(int target, int[] coins) {
        return countingChange(target, coins, 0);
    }

    public static int countingChange(int target, int[] coins, int index) {
        if(target == 0) {
            return 1;
        }
        if(target < 0 || index >= coins.length){
            return 0;
        }

        int leftTree = countingChange(target - coins[index], coins, index);
        int rightTree = countingChange(target, coins, index+1);

        return leftTree + rightTree;
    }
}
