package sliding_window;

public class Problem19 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

        int mostK = niceSubArrays(nums, k);
        int mostKMinOne = niceSubArrays(nums, k - 1);

        int kNice = mostK - mostKMinOne;

        System.out.println("#" +kNice);
    }

    public static int niceSubArrays(int[] nums, int k) {
        int subArrCount = 0;
        int oddCount = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];


            if(currentNum % 2 != 0){
                oddCount++;
            }

            while(oddCount > k) {
                int leftNum = nums[left];
                if(leftNum % 2 != 0){
                    oddCount--;
                }
                left++;
            }

            subArrCount += right - left + 1;

        }

        return subArrCount;
    }
}
