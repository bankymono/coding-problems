package sliding_window;

public class Problem17 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,1,0,1,1};

        System.out.println(longestOneArrays(nums));

    }

    public static int longestOneArrays(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

            if(currentNum == 0){
                zeroCount++;
            }

            if(zeroCount > 1) {
                left = right + 1;
                zeroCount--;
            }


            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength - 1;
    }
}
