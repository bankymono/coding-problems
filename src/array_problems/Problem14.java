package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem14 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(validSudoku(board));
    }

    public static boolean validSudoku(char[][] board) {
        Map<Integer, List<Character>> rowMap = new HashMap<>();
        Map<Integer, List<Character>> colMap = new HashMap<>();
        Map<Integer, List<Character>> boxMap = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int boxKey = (i/3) * 3 + (j * 3);

                if(board[i][j] == '.') continue;

                rowMap.putIfAbsent(i, new ArrayList<>());
                colMap.putIfAbsent(j, new ArrayList<>());
                boxMap.putIfAbsent(boxKey, new ArrayList<>());

                if(rowMap.get(i).contains(board[i][j])
                || colMap.get(j).contains(board[i][j])
                || boxMap.get(boxKey).contains(board[i][j])) {
                    return false;
                }

                rowMap.get(i).add(board[i][j]);
                colMap.get(j).add(board[i][j]);
                boxMap.get(boxKey).add(board[i][j]);
            }
        }

        return true;
    }
}
