package StringCompression443;

import java.util.List;

public class Solution {
    private record TestCase(char[] chars, int expectedResult, char[] modifiedChars) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}, 6, new char[]{'a', '2', 'b', '2', 'c', '3'}),
                new Solution.TestCase(new char[]{'a'}, 1, new char[]{'a'}),
                new Solution.TestCase(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, 4, new char[]{'a', 'b', '1', '2'}),
                new Solution.TestCase(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}, 6, new char[]{'a', '3', 'b', '2', 'a', '2'}),
                new Solution.TestCase(new char[]{'a', 'a', 'a', 'a', 'a', 'b'}, 3, new char[]{'a', '5', 'b'})
        );

        for (TestCase testCase : testCases) {
            System.out.println(compress(testCase.chars) == (testCase.expectedResult));

            boolean isEqual = true;
            for (int i = 0; i < testCase.modifiedChars.length; i++) {
                if (testCase.modifiedChars[i] != testCase.chars[i]) {
                    isEqual = false;
                    break;
                }
            }
            System.out.println(isEqual);
        }
    }

    public static int compress(char[] chars) {
        int start = 0, current = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[start]) {
                chars[current] = chars[start];
                char[] counts = splitCounts(start, i);
                for (int j = 0; j < counts.length; j++)
                    chars[current + j + 1] = counts[j];

                current += counts.length + 1;
                start = i;
            }
        }

        return current;
    }

    private static char[] splitCounts(int start, int end) {
        if (end - start <= 1) {
            return new char[0];
        }

        int count = end - start;
        int length = (int) Math.log10(count) + 1;
        char[] result = new char[length];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = (char) (count % 10 + '0');
            count /= 10;
        }

        return result;
    }
}
