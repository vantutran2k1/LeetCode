package LengthofLastWord58;

import java.util.List;

public class Solution {
    private record TestCase(String s, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("Hello World", 5),
                new Solution.TestCase("   fly me   to   the moon  ", 4),
                new Solution.TestCase("luffy is still joyboy", 6)
        );

        for (TestCase testCase : testCases) {
            System.out.println(lengthOfLastWord(testCase.s) == (testCase.expectedResult));
        }
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        boolean found = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                found = true;
                length++;
            }

            if (s.charAt(i) == ' ' && found) break;
        }

        return length;
    }
}
