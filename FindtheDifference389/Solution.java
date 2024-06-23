package FindtheDifference389;

import java.util.*;

public class Solution {
    private record TestCase(String s, String t, char expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("abcd", "abcde", 'e'),
                new Solution.TestCase("", "y", 'y')
        );

        for (TestCase testCase : testCases) {
            System.out.println(findTheDifference(testCase.s, testCase.t) == (testCase.expectedResult));
        }
    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!chars.containsKey(c)) {
                return c;
            }

            if (chars.get(c) == 1)
                chars.remove(c);
            else
                chars.put(c, chars.get(c) - 1);
        }

        return chars.entrySet().iterator().next().getKey();
    }
}
