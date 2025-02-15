package sliding_window;

public class Problem17 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1,1,1};

        System.out.println(longestOneArrays(nums));

    }

    public static int longestOneArrays(int[] nums) {
        int left = 0, maxLength = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If there are more than 1 zero, shrink the window from the left
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // We must delete **exactly one** element, so length is (right - left)
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
