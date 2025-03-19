package array_problems;

public class Problem39 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int k = 7;

        System.out.println(smallestSum(nums, k));   
    }

    public static int smallestSum(int[] nums, int k){
        int left = 0;
        int smallestLength = Integer.MAX_VALUE;
        int sum = 0;

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            while(sum > k) {
                smallestLength =Math.min(right - left + 1, smallestLength);

                sum -= nums[left];
                left++;
            }
        }

        return smallestLength;
    }
}
