package SearchInsertPosition35;

import java.util.List;

public class Solution {
    private record TestCase(int[] nums, int target, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 3, 5, 6}, 5, 2),
                new Solution.TestCase(new int[]{1, 3, 5, 6}, 2, 1),
                new Solution.TestCase(new int[]{1, 3, 5, 6}, 7, 4),
                new Solution.TestCase(new int[]{1, 3, 5, 6}, 0, 0)
        );

        for (TestCase testCase : testCases) {
            System.out.println(searchInsert(testCase.nums, testCase.target) == (testCase.expectedResult));
        }
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (right + left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        if (nums[left] < target)
            return left + 1;
        return left;
    }
}
