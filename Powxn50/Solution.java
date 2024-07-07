package Powxn50;

import java.util.List;

public class Solution {
    private record TestCase(double x, int n, double expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(2.00000, 10, 1024.00000),
                new Solution.TestCase(2.10000, 3, 9.26100),
                new Solution.TestCase(2.00000, -2, 0.25000)
        );

        for (TestCase testCase : testCases) {
            System.out.println(myPow(testCase.x, testCase.n) == (testCase.expectedResult));
        }
    }

    public static double myPow(double x, int n) {
        return myPow(x, n, true);
    }

    private static double myPow(double x, int n, boolean flag) {
        if (n == 0 || x == 1)
            return 1;
        if (x == 0)
            return 0;

        if (n < 0 && flag) {
            x = 1 / x;
            n = -n;
            flag = false;
        }

        double halfPow = myPow(x, n / 2, flag);
        if (n % 2 == 0)
            return halfPow * halfPow;
        return halfPow * halfPow * x;
    }
}
