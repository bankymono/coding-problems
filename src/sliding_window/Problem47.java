package sliding_window;

public class Problem47 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

        System.out.println(distinctKNiceArrays(nums, k));
    }

    public static int distinctKNiceArrays(int[] nums, int k) {
        return mostKNiceArrays(nums, k) - mostKNiceArrays(nums, k - 1);
    }

    public static int mostKNiceArrays(int[] nums, int k) {
        int niceCount = 0;
        int kReach = 0;

        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

            if(currentNum % 2 != 0) {
                kReach++;
            }

            while(kReach > k) {

                int leftNum = nums[left];

                if(leftNum % 2 != 0) {
                    kReach--;
                }
                left++;
            }

            niceCount += right - left + 1;
        }

        return niceCount;
    }
}
