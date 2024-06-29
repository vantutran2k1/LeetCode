package RomantoInteger13;

import java.util.List;
import java.util.Map;

public class Solution {
    private record TestCase(String s, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("III", 3),
                new Solution.TestCase("LVIII", 58),
                new Solution.TestCase("MCMXCIV", 1994)
        );

        for (TestCase testCase : testCases) {
            System.out.println(romanToInt(testCase.s) == (testCase.expectedResult));
        }
    }

    public static int romanToInt(String s) {
        final char I = 'I';
        final char V = 'V';
        final char X = 'X';
        final char L = 'L';
        final char C = 'C';
        final char D = 'D';
        final char M = 'M';

        Map<Character, Integer> romanChars = Map.of(I, 1, V, 5, X, 10, L, 50, C, 100, D, 500, M, 1000);

        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return romanChars.getOrDefault(chars[0], 0);
        }

        int result = romanChars.getOrDefault(chars[chars.length - 1], 0);
        for (int i = chars.length - 2; i >= 0; i--) {
            if (!romanChars.containsKey(chars[i]))
                return result;

            if (
                    chars[i] == I && (chars[i + 1] == V || chars[i + 1] == X) ||
                            chars[i] == X && (chars[i + 1] == L || chars[i + 1] == C) ||
                            chars[i] == C && (chars[i + 1] == D || chars[i + 1] == M)
            )
                result -= romanChars.get(chars[i]);
            else
                result += romanChars.get(chars[i]);
        }

        return result;
    }
}
