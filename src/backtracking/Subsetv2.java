package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsetv2 {
    public static int callCounter = 0;
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), resultList);
//        System.out.println(resultList);
        return resultList;
    }

    public static void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        System.out.println("currentIndex at the beginning of backtrack method -> " + index);
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            System.out.println(result);
            return;
        }

        // ✅ Decision 1: INCLUDE nums[index]
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);
        System.out.println("currentIndex, after return, before remove -> " + index);


        // 🧹 Backtrack: remove the element you just added
        current.remove(current.size() - 1);

        // ❌ Decision 2: SKIP nums[index]
        backtrack(index + 1, nums, current, result);
    }
}
