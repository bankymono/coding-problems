package backtracking;

public class SudokuSolver {
    public static void main(String[] args) {

    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // check row
        for(int i = 0; i < board.length; i++) {
            if(board[row][i] == num) {
                return false;
            }
        }

        // check col
        for(int[] nums : board) {
            if(nums[col] == num) {
                return false;
            }
        }

        // check 3 * 3 grid
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for(int r = rowStart; r < rowStart + sqrt; r++) {
            for(int c = colStart; c < colStart + sqrt; c++) {
                if(board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;



    }
}
