package IncreasingTripletSubsequence334;

import java.util.List;

public class Solution {
    private record TestCase(int[] nums, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 2, 3, 4, 5}, true),
                new Solution.TestCase(new int[]{5, 4, 3, 2, 1}, false),
                new Solution.TestCase(new int[]{2, 1, 5, 0, 4, 6}, true)
        );

        for (TestCase testCase : testCases) {
            System.out.println(increasingTriplet(testCase.nums) == testCase.expectedResult);
        }
    }

    public static boolean increasingTriplet(int[] nums) {
        int currentMin = Integer.MAX_VALUE;
        int[] values = new int[]{nums[0], Integer.MAX_VALUE};
        for (int num : nums) {
            if (values[1] < num)
                return true;

            if (num > values[0] && num < values[1])
                values[1] = num;
            else if (num < values[0] && num < currentMin)
                currentMin = num;
            else if (num > currentMin && num < values[1]) {
                values[0] = currentMin;
                values[1] = num;
                currentMin = Integer.MAX_VALUE;
            }
        }

        return false;
    }
}
