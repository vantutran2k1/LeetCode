package ToLowerCase709;

import java.util.List;
import java.util.Objects;

public class Solution {
    private record TestCase(String s, String expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("Hello", "hello"),
                new Solution.TestCase("here", "here"),
                new Solution.TestCase("LOVELY", "lovely")
        );

        for (TestCase testCase : testCases) {
            System.out.println(Objects.equals(toLowerCase(testCase.s), testCase.expectedResult));
        }
    }

    public static String toLowerCase(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                chars[i] = (char) (s.charAt(i) + 32);
            else
                chars[i] = s.charAt(i);
        }

        return new String(chars);
    }
}
