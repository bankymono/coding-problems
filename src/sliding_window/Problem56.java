package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Problem56 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        System.out.println(deleteOne(nums));
    }

    public static int deleteOne(int[] nums) {

        int countZero = 0;
        int oneLength = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

            if(currentNum == 0) {
                countZero++;
            }



            while(countZero > 1) {
                    int leftNum = nums[left];
                if(leftNum == 0){
                    countZero--;
                }
                left++;
            }

            oneLength = Math.max(oneLength, right - left);
        }

        return oneLength;
    }
}
