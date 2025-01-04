package hashmap_problems;

import java.util.*;

public class Problem18 {
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

        System.out.println(board + "is valid sudoku ->" + isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board){
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();


        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board.length; ++j){
                char ch = board[i][j];

                if(ch == '.') continue;

                int boxIndex = (i / 3) * 3 + (j/3);

                rowMap.putIfAbsent(i, new HashSet<>());
                colMap.putIfAbsent(j, new HashSet<>());
                boxMap.putIfAbsent(boxIndex, new HashSet<>());

                if(rowMap.get(i).contains(ch)
                || colMap.get(j).contains(ch)
                || boxMap.get(boxIndex).contains(ch)){
                    return false;
                }

                rowMap.get(i).add(ch);
                colMap.get(j).add(ch);
                boxMap.get(boxIndex).add(ch);
            }
        }

        return true;
    }

}
