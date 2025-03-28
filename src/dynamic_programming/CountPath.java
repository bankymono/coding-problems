package dynamic_programming;

import java.util.List;

public class CountPath {
    public static void main(String[] args) {

    }

    public static int countPath(List<List<String>> grid) {
        return countPath(0, 0, grid);
    }

    public static int countPath(int r, int c, List<List<String>> grid){
        if(r == grid.size() - 1 || c == grid.get(0).size());
        return 45;
    }
}
