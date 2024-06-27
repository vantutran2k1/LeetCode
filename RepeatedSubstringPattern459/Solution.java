package RepeatedSubstringPattern459;

import java.util.List;

public class Solution {
    private record TestCase(String s, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("abab", true),
                new Solution.TestCase("aba", false),
                new Solution.TestCase("abcabcabcabc", true)
        );

        for (TestCase testCase : testCases) {
            System.out.println(repeatedSubstringPattern(testCase.s) == (testCase.expectedResult));
        }
    }

    public static boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String modifiedString = doubled.substring(1, doubled.length() - 1);

        return modifiedString.contains(s);
    }
}
