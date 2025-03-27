package sliding_window;

public class Problem48 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1};

        System.out.println(binaryArrays(nums));
    }

    public static int binaryArrays(int[] nums) {
        int zeroCount = 0;
        
        int left = 0;
        int longestOnes = 0;

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

            if(currentNum == 0) {
                zeroCount++;
            }

            while(zeroCount >= 2) {
                int leftNum = nums[left];

                if(leftNum == 0) {
                    zeroCount--;
                }

                left++;
            }

            longestOnes = Math.max(longestOnes, right - left);
        }

        return longestOnes;
    }
}
