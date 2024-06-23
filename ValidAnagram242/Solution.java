package ValidAnagram242;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private record TestCase(String s, String t, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase("anagram", "nagaram", true),
                new Solution.TestCase("rat", "car", false),
                new Solution.TestCase("ab", "a", false)
        );

        for (TestCase testCase : testCases) {
            System.out.println(isAnagram(testCase.s, testCase.t) == (testCase.expectedResult));
        }
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!chars.containsKey(c))
                return false;

            if (chars.get(c) > 1)
                chars.put(c, chars.get(c) - 1);
            else
                chars.remove(c);
        }

        return chars.isEmpty();
    }
}
