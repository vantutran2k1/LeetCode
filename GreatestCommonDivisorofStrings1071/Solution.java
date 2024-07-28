package GreatestCommonDivisorofStrings1071;

import java.util.List;
import java.util.Objects;

public class Solution {
    private record TestCase(String str1, String str2, String expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("ABCABC", "ABC", "ABC"),
                new Solution.TestCase("ABABAB", "ABAB", "AB"),
                new Solution.TestCase("LEET", "CODE", "")
        );

        for (TestCase testCase : testCases) {
            System.out.println(Objects.equals(gcdOfStrings(testCase.str1, testCase.str2), testCase.expectedResult));
        }
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (isEmpty(str1) || isEmpty(str2)) return "";
        if (str1.equals(str2)) return str1;

        if (str1.length() > str2.length()) return gcdOfStrings(subtract(str1, str2), str2);
        return gcdOfStrings(str1, subtract(str2, str1));
    }

    private static String subtract(String str1, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            if (i >= str1.length() || str1.charAt(i) != str2.charAt(i))
                return "";
        }

        return str1.substring(str2.length());
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
