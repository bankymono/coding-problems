package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    private static final Map<String, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(gridTraveller(18,18));
    }

    public static long gridTraveller(int m, int n) {
        String key = m + "," + n;
        if(memo.containsKey(key)) return memo.get(key);

        if(m == 0) return 0;
        if(n == 0) return 0;
        if(m == 1) return 1;
        if(n == 1) return 1;


        long result = gridTraveller(m, n - 1) + gridTraveller(m - 1, n);
        memo.put(key, result);
        return result;
    }
    
}
