package CountOddNumbersinanIntervalRange1523;

import java.util.List;

public class Solution {
    private record TestCase(int low, int high, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(3, 7, 3),
                new Solution.TestCase(8, 10, 1)
        );

        for (TestCase testCase : testCases) {
            System.out.println(countOdds(testCase.low, testCase.high) == (testCase.expectedResult));
        }
    }

    public static int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0)
            return (high - low) / 2;

        return (high - low) / 2 + 1;
    }
}
