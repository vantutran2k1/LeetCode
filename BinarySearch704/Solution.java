package BinarySearch704;

import java.util.List;

public class Solution {
    private record TestCase(int[] nums, int target, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                new Solution.TestCase(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
        );

        for (TestCase testCase : testCases) {
            System.out.println(search(testCase.nums, testCase.target) == (testCase.expectedResult));
        }
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
