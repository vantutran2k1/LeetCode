package SetMatrixZeroes73;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private record TestCase(int[][] matrix, int[][] expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}),
                new Solution.TestCase(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}, new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}})
        );

        for (TestCase testCase : testCases) {
            setZeroes(testCase.matrix);
            System.out.println(arrayEquals(testCase.matrix, testCase.expectedResult));
        }
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> updatedRows = new HashSet<>();
        Set<Integer> updatedCols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    updatedRows.add(i);
                    updatedCols.add(j);
                }

        for (int row : updatedRows)
            setRowZeroes(matrix, row);

        for (int col : updatedCols)
            setColZeroes(matrix, col);
    }

    private static void setRowZeroes(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++)
            matrix[row][i] = 0;
    }

    private static void setColZeroes(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++)
            matrix[i][col] = 0;
    }

    private static boolean arrayEquals(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length)
            return false;

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] != b[i][j]) return false;

        return true;
    }
}
