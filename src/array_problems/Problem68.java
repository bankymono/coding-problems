package array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem68 {
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
                {'.', '.', '.', '.', '8', '8', '.', '7', '9'}
        };

        System.out.println(isValid(board));
    }

        public static boolean isValid(char[][] board) {
            Map<Integer, List<Character>> rowMap = new HashMap<>();
            Map<Integer, List<Character>> colMap = new HashMap<>();
            Map<Integer, List<Character>> boxMap = new HashMap<>();

            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    if(board[i][j] == '.') {
                        continue;
                    }
                    int boxIndex = (i/3) * 3 + (j / 3);

                    rowMap.putIfAbsent(i, new ArrayList<>());
                    colMap.putIfAbsent(j, new ArrayList<>());
                    boxMap.putIfAbsent(boxIndex, new ArrayList<>());
                    char currentPos = board[i][j];

                    if(rowMap.get(i).contains(currentPos)
                    || colMap.get(j).contains(currentPos)
                    || boxMap.get(boxIndex).contains(currentPos)) {
                        return false;
                    }

                    rowMap.get(i).add(currentPos);
                    colMap.get(j).add(currentPos);
                    boxMap.get(boxIndex).add(currentPos);
                }
            }

            return true;
        }
    
}
