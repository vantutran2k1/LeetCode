package FindFirstandLastPositionofElementinSortedArray34;

import java.util.Arrays;
import java.util.List;

public class Solution {
    private record TestCase(int[] nums, int target, int[] expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                new Solution.TestCase(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                new Solution.TestCase(new int[]{}, 0, new int[]{-1, -1}),
                new Solution.TestCase(new int[]{2, 2}, 2, new int[]{0, 1}),
                new Solution.TestCase(new int[]{0, 0, 1, 1, 1, 2, 3, 4, 4, 5, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 10}, 4, new int[]{7, 8}),
                new Solution.TestCase(new int[]{0, 0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4}, 3, new int[]{8, 11})
        );

        for (TestCase testCase : testCases) {
            System.out.println(Arrays.equals(searchRange(testCase.nums, testCase.target), testCase.expectedResult));
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                result[0] = findFirstIndex(nums, mid);
                result[1] = findLastIndex(nums, mid);
                return result;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int findFirstIndex(int[] nums, int end) {
        if (end == 0 || nums[end - 1] < nums[end])
            return end;

        int left = 0, right = end - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] < nums[end])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    private static int findLastIndex(int[] nums, int start) {
        if (start == nums.length - 1 || nums[start + 1] > nums[start])
            return start;

        int left = start + 1, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[start])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return right;
    }
}
