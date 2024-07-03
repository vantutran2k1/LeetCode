package MatrixDiagonalSum1572;

import java.util.List;

public class Solution {
    private record TestCase(int[][] mat, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 25),
                new Solution.TestCase(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}, 8),
                new Solution.TestCase(new int[][]{{5}}, 5)
        );

        for (TestCase testCase : testCases) {
            System.out.println(diagonalSum(testCase.mat) == (testCase.expectedResult));
        }
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++)
            sum += mat[i][i] + mat[i][mat.length - 1 - i];

        if (mat.length % 2 != 0)
            sum -= mat[mat.length / 2][mat.length / 2];

        return sum;
    }
}
