package FindtheIndexoftheFirstOccurrenceinaString28;

import java.util.List;

public class Solution {
    private record TestCase(String haystack, String needle, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("sadbutsad", "sad", 0),
                new Solution.TestCase("leetcode", "leeto", -1),
                new Solution.TestCase("a", "a", 0)
        );

        for (TestCase testCase : testCases) {
            System.out.println(strStr(testCase.haystack, testCase.needle) == (testCase.expectedResult));
        }
    }

    public static int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        int i = 0;
        boolean found;
        while (i < haystackLen - needleLen + 1) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                i++;
                continue;
            }

            found = true;
            for (int j = 1; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;
            }

            i++;
        }

        return -1;
    }
}
