package backtracking;

import java.util.List;

public class NKnights3 {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board, 0, 0, n);
    }

    public static void knight(boolean[][] board, int row, int col, int knights){
        if(knights == 0) {
            display(board);
            return;
        }

        if(row == board.length-1 && col == board[0].length) {
            return;
        }

        List<Integer> list = List.of(1,2,3,4,5);
        int sum = list.stream().map(val -> val * val)
                .reduce(0, (val, acc) -> val + acc);
        System.out.println("sum -> " + sum);

        if(col == board[0].length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if(isValid(board,row,col)) {
            board[row][col] = true;
            knight(board,row,col+1,knights - 1);
            board[row][col] = false;
        }

        knight(board, row, col + 1, knights);
    }

    public static boolean isValid(boolean[][] board, int row, int col) {
        if(validPosition(board,row - 1,col - 2)){
            if(board[row - 1][col - 2]){
                return false;
            }
        }

        if(validPosition(board,row-1,col+2)){
            if(board[row - 1][col + 2]){
                return false;
            }
        }

        if(validPosition(board,row-2,col-1)){
            if(board[row - 2][col - 1]){
                return false;
            }
        }

        if(validPosition(board,row-2,col+1)){
            if(board[row - 2][col + 1]){
                return false;
            }
        }

        return true;
    }

    public static boolean validPosition(boolean[][] board, int row, int col) {
        if(row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }

        return false;
    }

    public static void display(boolean[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length;j++) {
                if(board[i][j]){
                    System.out.print("K ");
                }else{
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
