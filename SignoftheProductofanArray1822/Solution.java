package SignoftheProductofanArray1822;

import java.util.List;

public class Solution {
    private record TestCase(int[] nums, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{-1, -2, -3, -4, 3, 2, 1}, 1),
                new Solution.TestCase(new int[]{1, 5, 0, 2, -3}, 0),
                new Solution.TestCase(new int[]{-1, 1, -1, 1, -1}, -1)
        );

        for (TestCase testCase : testCases) {
            System.out.println(arraySign(testCase.nums) == (testCase.expectedResult));
        }
    }

    public static int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int val : nums) {
            if (val == 0) {
                return 0;
            }

            if (val < 0) {
                negativeCount++;
            }
        }

        return negativeCount % 2 == 0 ? 1 : -1;
    }
}
