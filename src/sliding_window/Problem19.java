package sliding_window;

public class Problem19 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

        System.out.println("#" +niceSubArrays(nums, k));
        
    }

    public static int niceSubArrays(int[] nums, int k) {
        int subArrCount = 0;
        int nice = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

//            System.out.println(currentNum % 2);

            if(currentNum % 2 != 0){
                nice++;
            }

            while(nice > k) {
                int leftNum = nums[left];
                if(leftNum % 2 != 0){
                    nice--;
                }
                left++;
            }

            if(nice == k) {
                subArrCount++;
            }
        }

        return subArrCount;
    }
}
