package ReverseVowelsofaString345;

import java.util.List;
import java.util.Objects;

public class Solution {
    private record TestCase(String s, String expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("hello", "holle"),
                new Solution.TestCase("leetcode", "leotcede")
        );

        for (TestCase testCase : testCases) {
            System.out.println(Objects.equals(reverseVowels(testCase.s), testCase.expectedResult));
        }
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!isVowel(chars[i]))
                i++;
            if (!isVowel(chars[j]))
                j--;

            if (isVowel(chars[i]) && isVowel(chars[j]))
                swap(chars, i++, j--);
        }

        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static boolean isVowel(char c) {
        String VOWELS = "aeiouAEIOU";
        return VOWELS.indexOf(c) != -1;
    }
}
