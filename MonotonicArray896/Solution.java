package MonotonicArray896;

import java.util.List;

public class Solution {
    private record TestCase(int[] nums, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 2, 2, 3}, true),
                new Solution.TestCase(new int[]{6, 5, 4, 4}, true),
                new Solution.TestCase(new int[]{1, 3, 2}, false)
        );

        for (TestCase testCase : testCases) {
            System.out.println(isMonotonic(testCase.nums) == (testCase.expectedResult));
        }
    }

    public static boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isIncreasing = false;
            } else if (nums[i] < nums[i + 1]) {
                isDecreasing = false;
            }

            if (!isIncreasing && !isDecreasing) {
                return false;
            }
        }

        return true;
    }
}
