package CountNegativeNumbersinaSortedMatrix1351;

import java.util.List;

public class Solution {
    private record TestCase(int[][] grid, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}, 8),
                new Solution.TestCase(new int[][]{{3, 2}, {1, 0}}, 0)
        );

        for (TestCase testCase : testCases) {
            System.out.println(countNegatives(testCase.grid) == (testCase.expectedResult));
        }
    }

    public static int countNegatives(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;

        int count = 0;
        int col = 0;
        int row = rows - 1;
        while (row >= 0 && col < cols) {
            if (grid[row][col] < 0) {
                count += cols - col;
                row -= 1;
            } else
                col += 1;
        }

        return count;
    }
}
