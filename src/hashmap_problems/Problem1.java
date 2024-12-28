package hashmap_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        System.out.println(String.format("key -> %s, value -> %s\n",3, map.get(3)));
        map.put(3,"Coconut");
        map.remove(1);

        for(int i : map.keySet()){
            System.out.println(String.format("key -> %s, value -> %s", i, map.get(i)));
        }
    }
}
