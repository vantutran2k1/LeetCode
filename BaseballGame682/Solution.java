package BaseballGame682;

import java.util.List;

public class Solution {
    private record TestCase(String[] operations, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new String[]{"5", "2", "C", "D", "+"}, 30),
                new Solution.TestCase(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}, 27),
                new Solution.TestCase(new String[]{"1", "C"}, 0)
        );

        for (TestCase testCase : testCases) {
            System.out.println(calPoints(testCase.operations) == (testCase.expectedResult));
        }
    }

    public static int calPoints(String[] operations) {
        int last = -1;
        int[] records = new int[operations.length];
        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    records[last + 1] += records[last] + records[last - 1];
                    last++;
                }
                case "D" -> {
                    records[last + 1] = records[last] * 2;
                    last++;
                }
                case "C" -> records[last--] = 0;
                default -> records[++last] = Integer.parseInt(operation);
            }
        }

        int sum = 0;
        for (int i = 0; i <= last; i++) {
            sum += records[i];
        }

        return sum;
    }
}
