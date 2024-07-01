package RobotReturntoOrigin657;

import java.util.List;

public class Solution {
    private record TestCase(String moves, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("UD", true),
                new Solution.TestCase("LL", false)
        );

        for (TestCase testCase : testCases) {
            System.out.println(judgeCircle(testCase.moves) == (testCase.expectedResult));
        }
    }

    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U': {
                    y++;
                    break;
                }
                case 'D': {
                    y--;
                    break;
                }
                case 'L': {
                    x--;
                    break;
                }
                case 'R': {
                    x++;
                    break;
                }
                default:
                    break;
            }
        }

        return x == 0 && y == 0;
    }
}
