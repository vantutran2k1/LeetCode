package CheckIfItIsaStraightLine1232;

import java.util.List;

public class Solution {
    private record TestCase(int[][] coordinates, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}, true),
                new Solution.TestCase(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}, false)
        );

        for (TestCase testCase : testCases) {
            System.out.println(checkStraightLine(testCase.coordinates) == (testCase.expectedResult));
        }
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int[] first = coordinates[0];
        int[] second = coordinates[1];

        float slope, c;
        int i;
        
        if (first[0] == second[0]) {
            for (i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != first[0])
                    return false;
            }
        } else if (first[1] == second[1]) {
            for (i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != first[1])
                    return false;
            }
        } else {
            slope = (float) (second[1] - first[1]) / (first[0] - second[0]);
            c = slope * first[0] + first[1];
            for (i = 2; i < coordinates.length; i++) {
                if (slope * coordinates[i][0] + coordinates[i][1] != c)
                    return false;
            }
        }

        return true;
    }
}
