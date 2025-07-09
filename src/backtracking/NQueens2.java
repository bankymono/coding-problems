package backtracking;

public class NQueens2 {
    public static void main(String[] args) {
        int n = 8;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }


    static int queens(boolean[][] board, int row) {
        if(row == board.length) {
            display(board);
            return 1;
        }

        int count = 0;

        for(int col = 0; col < board[0].length; col++){
            if(isValid(row,col, board)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    public static boolean isValid(int row, int col, boolean[][] board) {
        for(int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        int maxLeft = Math.min(row,col);
        for(int i = 1; i <= maxLeft; i++) {
            if(board[row - i][col - i]){
                return false;
            }
        }

        int maxRight = Math.min(row,board[0].length - col - 1);
        for(int i = 1; i <= maxRight; i++) {
            if(board[row - i][col + i]){
                return false;
            }
        }

        return true;
    }

    static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean col : row) {
                if(col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
