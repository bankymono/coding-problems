package hashmap_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem40 {
    

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

        System.out.println(String.format("good board -> %s", isValidSudoku(board)));    
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();

        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                char num = board[i][j]; 
                if(num == '.') continue;


                int boxIndex = (i/3) * 3 + (j/3);

                rowMap.putIfAbsent(i, new HashSet<>());
                colMap.putIfAbsent(j, new HashSet<>());
                boxMap.putIfAbsent(boxIndex, new HashSet<>());

                if(rowMap.get(i).contains(num) ||
                   colMap.get(j).contains(num) ||
                   boxMap.get(boxIndex).contains(num)) {
                    return false;
                }



                rowMap.get(i).add(num);
                colMap.get(j).add(num);
                boxMap.get(boxIndex).add(num);
            }
        }

        return true;
    }
}
