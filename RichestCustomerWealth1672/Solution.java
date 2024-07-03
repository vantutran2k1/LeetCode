package RichestCustomerWealth1672;

import java.util.List;

public class Solution {
    private record TestCase(int[][] accounts, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[][]{{1, 2, 3}, {3, 2, 1}}, 6),
                new Solution.TestCase(new int[][]{{1, 5}, {7, 3}, {3, 5}}, 10),
                new Solution.TestCase(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}, 17)
        );

        for (TestCase testCase : testCases) {
            System.out.println(maximumWealth(testCase.accounts) == (testCase.expectedResult));
        }
    }

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int currentWealth;
        for (int[] account : accounts) {
            currentWealth = 0;
            for (int money : account) {
                currentWealth += money;
            }

            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }

        return maxWealth;
    }
}
