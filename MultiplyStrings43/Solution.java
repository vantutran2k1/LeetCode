package MultiplyStrings43;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    private record TestCase(String num1, String num2, String expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("2", "3", "6"),
                new Solution.TestCase("123", "456", "56088"),
                new Solution.TestCase("9", "9", "81"),
                new Solution.TestCase("9133", "0", "0")
        );

        for (TestCase testCase : testCases) {
            System.out.println(Objects.equals(multiply(testCase.num1, testCase.num2), testCase.expectedResult));
        }
    }

    public static String multiply(String num1, String num2) {
        int totalLength = num1.length() + num2.length();

        int[][] subArrays = new int[num1.length()][totalLength];
        int carry;
        int current;

        for (int i = 0; i < num1.length(); i++) {
            int j;
            carry = 0;
            for (j = 0; j < num2.length(); j++) {
                current = getValueAtIndex(num1, num1.length() - 1 - i) * getValueAtIndex(num2, num2.length() - 1 - j) + carry;
                subArrays[i][totalLength - 1 - j - i] = current % 10;
                carry = current / 10;
            }

            if (carry != 0) {
                subArrays[i][totalLength - i - j - 1] = carry;
            }
        }

        int[] results = new int[totalLength];
        carry = 0;
        for (int i = totalLength - 1; i >= 0; i--) {
            current = carry;
            for (int[] subArray : subArrays) {
                current += subArray[i];
            }

            results[i] = current % 10;
            carry = current / 10;
        }

        for (int i = 0; i < results.length; i++) {
            if (results[i] != 0)
                return arrayToString(Arrays.copyOfRange(results, i, results.length));
        }

        return "0";
    }

    private static int getValueAtIndex(String num, int index) {
        return charToInt(num.charAt(index));
    }

    private static int charToInt(char c) {
        return c - '0';
    }

    private static String arrayToString(int[] arr) {
        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining());
    }
}
