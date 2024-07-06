package AverageSalaryExcludingtheMinimumandMaximumSalary1491;

import java.util.List;

public class Solution {
    private record TestCase(int[] salary, double expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{4000, 3000, 1000, 2000}, 2500.00000),
                new Solution.TestCase(new int[]{1000, 2000, 3000}, 2000.00000)
        );

        for (TestCase testCase : testCases) {
            System.out.println(average(testCase.salary) == (testCase.expectedResult));
        }
    }

    public static double average(int[] salary) {
        int minValue = salary[0];
        int maxValue = salary[0];
        int sum = 0;

        for (int value : salary) {
            if (value < minValue)
                minValue = value;
            if (value > maxValue)
                maxValue = value;

            sum += value;
        }

        return (double) (sum - minValue - maxValue) / (salary.length - 2);
    }
}
