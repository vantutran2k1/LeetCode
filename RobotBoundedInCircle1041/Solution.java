package RobotBoundedInCircle1041;

import java.util.List;

public class Solution {
    private record TestCase(String instructions, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("GGLLGG", true),
                new Solution.TestCase("GG", false),
                new Solution.TestCase("GL", true)
        );

        for (TestCase testCase : testCases) {
            System.out.println(isRobotBounded(testCase.instructions) == (testCase.expectedResult));
        }
    }

    public static boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dx = 0, dy = 1;
        int temp;

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x += dx;
                y += dy;
            } else if (c == 'L') {
                temp = dx;
                dx = -dy;
                dy = temp;
            } else if (c == 'R') {
                temp = dx;
                dx = dy;
                dy = -temp;
            }
        }

        return dx != 0 || dy != 1 || (x == 0 && y == 0);
    }
}
