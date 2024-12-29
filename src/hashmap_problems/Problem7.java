package hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef","bdfg", "xyz", "az", "ba", "a", "z"};
        System.out.println(getGroupedShifting(input));
    }

    public static List<List<String>> getGroupedShifting(String[] input) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < input.length; ++i){
            String key = getGroupKey(input[i]);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(input[i]);
        }

        return new ArrayList(map.values());
    }

    public static String getGroupKey(String input){
        StringBuilder userString = new StringBuilder();
        if(input.length() == 1) return "single";
        for(int i = 1; i < input.length(); ++i ){
            int diff = (input.charAt(i) - input.charAt(i - 1) + 26) % 26;
            userString.append(diff).append(",");
        }

        return userString.toString();
    }
}
