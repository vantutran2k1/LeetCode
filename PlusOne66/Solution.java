package PlusOne66;

import java.util.Arrays;
import java.util.List;

public class Solution {
    private record TestCase(int[] digits, int[] expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                new Solution.TestCase(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                new Solution.TestCase(new int[]{9}, new int[]{1, 0})
        );

        for (TestCase testCase : testCases) {
            System.out.println(Arrays.equals(plusOne(testCase.digits), testCase.expectedResult));
        }
    }

    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];

        int carry = 1;
        int currentTotal;
        for (int i = digits.length - 1; i >= 0; i--) {
            currentTotal = digits[i] + carry;
            if (currentTotal > 9) {
                carry = 1;
                result[i] = currentTotal - 10;
            } else {
                carry = 0;
                result[i] = currentTotal;
            }
        }

        if (carry > 0) {
            result[0] = carry;
            return result;
        }

        int[] subArray = new int[result.length - 1];
        System.arraycopy(result, 0, subArray, 0, result.length - 1);
        return subArray;
    }
}
