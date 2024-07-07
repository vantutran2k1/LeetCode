package LargestPerimeterTriangle976;

import java.util.Arrays;
import java.util.List;

public class Solution {
    private record TestCase(int[] nums, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{2, 1, 2}, 5),
                new Solution.TestCase(new int[]{1, 2, 1, 10}, 0)
        );

        for (TestCase testCase : testCases) {
            System.out.println(largestPerimeter(testCase.nums) == (testCase.expectedResult));
        }
    }

    public static int largestPerimeter(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        for (int i = sortedNums.length - 1; i >= 2; i--) {
            if (sortedNums[i - 2] > sortedNums[i] - sortedNums[i - 1])
                return sortedNums[i] + sortedNums[i - 1] + sortedNums[i - 2];
        }

        return 0;
    }
}
