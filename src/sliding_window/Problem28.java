package sliding_window;

public class Problem28 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1,1,1,0,1,1};
        int k = 2;

        System.out.println(longestZeroCount(nums, k));
    }

    public static int longestZeroCount(int[] nums, int k) {
        int longestLength = 0;

        int left = 0;
        int zeroCount = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeroCount++;


            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }


            longestLength = Math.max(longestLength, right - left + 1);
        }

        return longestLength;
    }
}
