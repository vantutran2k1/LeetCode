package MaximumNumberofVowelsinaSubstringofGivenLength1456;

import java.util.List;

public class Solution {
    private record TestCase(String s, int k, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("abciiidef", 3, 3),
                new Solution.TestCase("aeiou", 2, 2),
                new Solution.TestCase("leetcode", 3, 2)
        );

        for (TestCase testCase : testCases) {
            System.out.println(maxVowels(testCase.s, testCase.k) == (testCase.expectedResult));
        }
    }

    public static int maxVowels(String s, int k) {
        int maxLength = 0;

        int i = 0, currentLength = 0;
        for (; i < k; i++) {
            if (isVowel(s.charAt(i)))
                currentLength++;
        }

        if (currentLength == k)
            return currentLength;

        maxLength = currentLength;
        for (; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                currentLength++;
            if (isVowel(s.charAt(i - k)))
                currentLength--;

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    private static boolean isVowel(char c) {
        final String VOWELS = "aeiou";
        return VOWELS.indexOf(c) != -1;
    }
}
