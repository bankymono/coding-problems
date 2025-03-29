package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPathSum {
    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 3, 12),
                Arrays.asList(5, 6, 2));
        System.out.println(maxPathSum(grid));
    }

    public static int maxPathSum(List<List<Integer>> grid) {
        return maxPathSum(0, 0, grid, new HashMap<>());
    }

    public static int maxPathSum(int r, int c, List<List<Integer>> grid, Map<String, Integer> memo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r).append(",").append(c);
        String key = stringBuilder.toString();

        if(memo.containsKey(key)) return memo.get(key);

        if(r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return grid.get(r).get(c);
        }

        if(r == grid.size() || c == grid.get(0).size()){
            return Integer.MIN_VALUE;
        }

        int rowVal = maxPathSum(r+1, c, grid, memo);
        int colVal = maxPathSum(r, c+1, grid, memo);

        int maxVal = Math.max(rowVal, colVal);

        int result = maxVal + grid.get(r).get(c);
        memo.put(key, result);
        return result;
    }

}
