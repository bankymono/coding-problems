package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPath {
    public static void main(String[] args) {
//        List<List<String>> grid = Arrays.asList(
//                Arrays.asList("O", "O", "O", "O", "O"),
//                Arrays.asList("O", "O", "O", "X", "O"),
//                Arrays.asList("O", "O", "O", "O", "O"),
//                Arrays.asList("O", "O", "O", "O", "O"),
//                Arrays.asList("O", "O", "O", "O", "O")
//        );

        List<List<String>> grid = Arrays.asList(
//                Arrays.asList("O", "O", "O", "O", "O"),
//                Arrays.asList("O", "O", "O", "X", "O"),
//                Arrays.asList("O", "O", "O", "O", "O"),
                Arrays.asList("O", "X"),
                Arrays.asList("O", "O")
        );
        System.out.println(countPath(grid));
    }

    public static int countPath(List<List<String>> grid) {
        Map<String, Integer> memo = new HashMap<>();
        return countPath(0, 0, grid, memo);
    }

    public static int countPath(int r, int c, List<List<String>> grid, Map<String, Integer> memo){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r).append(",").append(c);

        if(memo.containsKey(stringBuilder.toString())) return memo.get(stringBuilder.toString());

        if(r == grid.size() || c == grid.get(0).size()) {
            return 0;
        }

        if(grid.get(r).get(c).equals("X")) {
            return  0;
        }

        if(r == grid.size() - 1 && c == grid.get(0).size() - 1){
            return 1;
        }

        int result = countPath(r + 1, c, grid, memo) + countPath(r, c + 1, grid, memo);
        memo.put(stringBuilder.toString(), result);
        return result;
    }
}
