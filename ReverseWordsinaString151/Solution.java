package ReverseWordsinaString151;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Solution {
    private record TestCase(String s, String expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("the sky is blue", "blue is sky the"),
                new Solution.TestCase("  hello world  ", "world hello"),
                new Solution.TestCase("a good   example", "example good a"),
                new Solution.TestCase("a good   example ", "example good a")
        );

        for (TestCase testCase : testCases) {
            System.out.println(Objects.equals(reverseWords(testCase.s), testCase.expectedResult));
        }
    }

    public static String reverseWords(String s) {
        int wordStart = 0;
        int wordEnd;
        Stack<String> words = new Stack<>();
        for (wordEnd = 0; wordEnd < s.length(); wordEnd++) {
            if (s.charAt(wordEnd) != ' ' && s.charAt(wordStart) == ' ') {
                wordStart = wordEnd;
            }

            if (s.charAt(wordEnd) == ' ' && s.charAt(wordStart) != ' ') {
                words.push(s.substring(wordStart, wordEnd));
                wordStart = wordEnd;
            }
        }

        if (s.charAt(wordEnd - 1) != ' ')
            words.push(s.substring(wordStart, wordEnd));

        return buildWords(words);
    }

    private static String buildWords(Stack<String> words) {
        StringBuilder builder = new StringBuilder();
        if (words.isEmpty())
            return "";

        while (words.size() > 1) {
            builder.append(words.pop());
            builder.append(" ");
        }
        builder.append(words.pop());

        return builder.toString();
    }
}
