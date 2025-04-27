package sliding_window;

public class Problem58 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

        System.out.println(niceArrays(nums, k));
    }

    public static int niceArrays(int[] nums, int k) {
        return niceArrayMost(nums, k) - niceArrayMost(nums, k - 1);
    }

    public static int niceArrayMost(int[] nums, int k) {
        int niceCount = 0;
        int arrCount = 0;

        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] % 2 != 0) {
                niceCount++;
            }

            while(niceCount > k) {
                if(nums[left] % 2 != 0) {
                    niceCount--;
                }

                left++;
            }

            arrCount += right - left + 1;
        }

        return arrCount;
    }
}
