package MergeStringsAlternately1768;

import java.util.List;

public class Solution {
    private record TestCase(String word1, String word2, String expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
            new TestCase("abc", "pqr", "apbqcr"),
            new TestCase("ab", "pqrs", "apbqrs"),
            new TestCase("abcd", "pq", "apbqcd"),
            new TestCase("cf", "eee", "cefee")
        );

        for (TestCase testCase : testCases) {
            System.out.println(mergeAlternately(testCase.word1, testCase.word2).equals(testCase.expectedResult));
        }
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int length1 = word1.length();
        int length2 = word2.length();
        int i = 0;
        while (i < Math.min(length1, length2)) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));

            i++;
        }

        if (i <= length1 - 1) {
            sb.append(word1.substring(i ));
        } else if (i <= length2 - 1) {
            sb.append(word2.substring(i));
        }

        return sb.toString();
    }
}
