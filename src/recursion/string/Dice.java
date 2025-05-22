package recursion.string;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
//        System.out.println(dice(););
//        dice("", 4);
        System.out.println(diceReturn("", 4));
    }

    public static void dice(String p, int target) {
        if(target == 0) {
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= 6; i++) {
            if(target - i >= 0){
                dice(p + i, target - i);
            }
        }
    }

    public static List<String> diceReturn(String p, int target) {
        if(target == 0) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        List<String> result = new ArrayList<>();
        for(int i = 1; i <= 6; i++) {
            if(target - i >= 0){
                result.addAll(diceReturn(p+ i, target - i));
            }
        }

        return result;
    }
}
