package array_problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class Problem73 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(maxValues(nums, k));
    }

    public static List<Integer> maxValues(int[] nums, int k) {
        Deque<Integer> maxIndices = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            while(!maxIndices.isEmpty() && maxIndices.peekFirst() < i - k + 1) {
                maxIndices.pollFirst();
            }

            while(!maxIndices.isEmpty() && nums[maxIndices.peekLast()] < nums[i]) {
                maxIndices.pollLast();
            }

            maxIndices.offerLast(i);


            if(i >= k) {
                result.add(nums[maxIndices.peekFirst()]);
            }
        }

        return result;
    }
}