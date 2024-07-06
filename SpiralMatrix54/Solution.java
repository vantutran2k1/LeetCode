package SpiralMatrix54;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    private record TestCase(int[][] matrix, List<Integer> expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                new Solution.TestCase(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}, List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
        );

        for (TestCase testCase : testCases) {
            System.out.println(listEquals(spiralOrder(testCase.matrix), testCase.expectedResult));
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> moves = new ArrayList<>();
        spiralOrder(matrix, moves, matrix.length, matrix[0].length, 0, -1, 0, 1);

        return moves;
    }

    private static void spiralOrder(int[][] matrix, List<Integer> moves, int m, int n, int r, int c, int dr, int dc) {
        if (m == 0 || n == 0) return;

        for (int i = 0; i < n; i++) {
            r += dr;
            c += dc;
            moves.add(matrix[r][c]);
        }

        spiralOrder(matrix, moves, n, m - 1, r, c, dc, -dr);
    }

    private static boolean listEquals(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size())
            return false;

        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i)))
                return false;
        }

        return true;
    }
}
