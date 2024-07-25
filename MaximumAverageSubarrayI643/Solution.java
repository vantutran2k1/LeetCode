package MaximumAverageSubarrayI643;

import java.util.List;

public class Solution {
    private record TestCase(int[] nums, int k, double expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75000),
                new Solution.TestCase(new int[]{5}, 1, 5.00000)
        );

        for (TestCase testCase : testCases) {
            System.out.println(findMaxAverage(testCase.nums, testCase.k) == (testCase.expectedResult));
        }
    }

    public static double findMaxAverage(int[] nums, int k) {
        int currentTotal = 0;
        int i;
        for (i = 0; i < k; i++)
            currentTotal += nums[i];

        int maxTotal = currentTotal;
        for (i = k; i < nums.length; i++) {
            currentTotal = currentTotal - nums[i - k] + nums[i];
            maxTotal = Math.max(maxTotal, currentTotal);
        }

        return (double) maxTotal / k;
    }
}
