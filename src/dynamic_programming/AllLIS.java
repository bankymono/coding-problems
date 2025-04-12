package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class AllLIS {
    public List<List<Integer>> findAllLIS(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, -1, new ArrayList<>(), result);

        // Filter only max-length sequences
        int maxLen = result.stream().mapToInt(List::size).max().orElse(0);
        List<List<Integer>> filtered = new ArrayList<>();
        for (List<Integer> seq : result) {
            if (seq.size() == maxLen) {
                filtered.add(new ArrayList<>(seq));
            }
        }
        return filtered;
    }

    private void backtrack(int[] nums, int index, int prevIndex, List<Integer> path, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Skip current
        backtrack(nums, index + 1, prevIndex, path, result);

        // Take current if it's valid
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            path.add(nums[index]);
            backtrack(nums, index + 1, index, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        AllLIS lis = new AllLIS();
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {3,10,2};
        List<List<Integer>> allLIS = lis.findAllLIS(nums);
        for (List<Integer> seq : allLIS) {
            System.out.println(seq);
        }
    }
}
