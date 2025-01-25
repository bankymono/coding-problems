package hashmap_problems;

import java.util.*;

public class Problem43 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subArraysSumtoK(nums, k));
    }

    public static List<List<Integer>> subArraysSumtoK(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        Map<Integer, List<Integer>> prefixSumIndices = new HashMap<>();
        int result = 0;
        List<List<Integer>> resultArray = new ArrayList<>();
        int currentSum = 0;

        prefixSum.put(0,1);
        prefixSumIndices.put(0, List.of(-1));

        for(int i = 0; i < nums.length; ++i) {
            currentSum += nums[i];

            if(prefixSumIndices.containsKey(currentSum - k)) {
                for(int start : prefixSumIndices.get(currentSum - k)) {
                    List<Integer> subArray = new ArrayList<>();
                    for(int j = start + 1; j <= i; ++j) {
                        subArray.add(nums[i]);
                    }

                    resultArray.add(subArray);
                }
            }

            prefixSumIndices.putIfAbsent(currentSum, new ArrayList<>());
            prefixSumIndices.get(currentSum).add(i);

        }

        return resultArray;
    }
}
