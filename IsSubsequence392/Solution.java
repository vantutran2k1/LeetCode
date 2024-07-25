package IsSubsequence392;

import java.util.List;

public class Solution {
    private record TestCase(String s, String t, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("abc", "ahbgdc", true),
                new Solution.TestCase("axc", "ahbgdc", false)
        );

        for (TestCase testCase : testCases) {
            System.out.println(isSubsequence(testCase.s, testCase.t) == testCase.expectedResult);
        }
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }

        return i == s.length();
    }
}
