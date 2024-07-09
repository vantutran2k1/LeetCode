package AddBinary67;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
    private record TestCase(String a, String b, String expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("0", "0", "0"),
                new Solution.TestCase("11", "1", "100"),
                new Solution.TestCase("1010", "1011", "10101")
        );

        for (TestCase testCase : testCases) {
            System.out.println(Objects.equals(addBinary(testCase.a, testCase.b), testCase.expectedResult));
        }
    }

    public static String addBinary(String a, String b) {
        if (a.length() < b.length())
            return doAddBinary(a, b);
        else {
            System.out.println(doAddBinary(b, a));
            return doAddBinary(b, a);
        }
    }

    private static String doAddBinary(String first, String second) {
        char[] chars = new char[second.length() + 1];
        int carry = 0;

        int currentSum;
        for (int i = 0; i < first.length(); i++) {
            currentSum = charToInt(first.charAt(first.length() - 1 - i)) + charToInt(second.charAt(second.length() - 1 - i));
            if (currentSum + carry < 2) {
                chars[chars.length - 1 - i] = intToChar(currentSum + carry);
                carry = 0;
            } else {
                chars[chars.length - 1 - i] = intToChar(currentSum + carry - 2);
                carry = 1;
            }
        }

        for (int i = second.length() - first.length() - 1; i >= 0; i--) {
            currentSum = charToInt(second.charAt(i)) + carry;
            if (currentSum < 2) {
                chars[i + 1] = intToChar(currentSum);
                carry = 0;
            } else {
                chars[i + 1] = '0';
                carry = 1;
            }
        }

        if (carry > 0) {
            chars[0] = '1';
            return new String(chars);
        } else {
            return new String(Arrays.copyOfRange(chars, 1, chars.length));
        }
    }

    private static char intToChar(int n) {
        return (char) (n + '0');
    }

    private static int charToInt(char c) {
        return c - '0';
    }
}
