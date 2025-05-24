package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(count(4, 3));
//        printPath("",4,3);
//        System.out.println(listPath("", 3, 3));
//        System.out.println(listPathDiagonal("", 3, 3));
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        printPathRestrictions("", board, 0,0);

    }

    public static int count(int r, int c) {
        if(r == 1 || c == 1) {
            return 1;
        }

        int down = count(r - 1, c);
        int right = count(r, c - 1);

        return down + right;
    }

    public static void printPath(String p,int r, int c) {
        if(r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
//        if(r < 1 || c < 1) {
//            return;
//        }



        if(r > 1) {
            printPath(p + "D", r -1, c);
        }

        if(c > 1) {
            printPath(p + "R", r, c-1);
        }


    }

    public static List<String> listPath(String p, int r, int c) {
        if(r == 1 && c == 1) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
//        if(r < 1 || c < 1) {
//            return;
//        }


        List<String> result = new ArrayList<>();
        if(r > 1) {
            result.addAll(listPath(p + "D", r -1, c));
        }

        if(c > 1) {
            result.addAll(listPath(p + "R", r, c-1));
        }

        return result;
    }

    public static List<String> listPathDiagonal(String p, int r, int c) {
        if(r == 1 && c == 1) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
//        if(r < 1 || c < 1) {
//            return;
//        }


        List<String> result = new ArrayList<>();
        if(r > 1 && c > 1) {
            result.addAll(listPathDiagonal(p + "D", r -1, c-1));
        }

        if(r > 1) {
            result.addAll(listPathDiagonal(p + "H", r -1, c));
        }

        if(c > 1) {
            result.addAll(listPathDiagonal(p + "V", r, c-1));
        }



        return result;
    }

    public static List<String> listPathRestrictions(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        if(!maze[r][c]) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        if(r < maze.length - 1) {
            result.addAll(listPathRestrictions(p + "D", maze,r -1, c));
        }

        if(c < maze[0].length - 1) {
            result.addAll(listPathRestrictions(p + "R", maze, r, c-1));
        }

        return result;
    }

    public static void printPathRestrictions(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if(!maze[r][c]) {
            return;
        }

        if(r < maze.length - 1) {
            printPathRestrictions(p + "D", maze, r + 1, c);
        }

        if(c < maze[0].length - 1) {
            printPathRestrictions(p + "R", maze, r, c + 1);
        }
    }
}
