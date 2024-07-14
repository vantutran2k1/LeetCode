package FindSmallestLetterGreaterThanTarget744;

import java.util.List;

public class Solution {
    private record TestCase(char[] letters, char target, char expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new char[]{'c', 'f', 'j'}, 'a', 'c'),
                new Solution.TestCase(new char[]{'c', 'f', 'j'}, 'c', 'f'),
                new Solution.TestCase(new char[]{'c', 'f', 'j'}, 'd', 'f'),
                new Solution.TestCase(new char[]{'c', 'f', 'j'}, 'j', 'c'),
                new Solution.TestCase(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e', 'n'),
                new Solution.TestCase(new char[]{'x', 'x', 'y', 'y'}, 'z', 'x')
        );

        for (TestCase testCase : testCases) {
            System.out.println(nextGreatestLetter(testCase.letters, testCase.target) == (testCase.expectedResult));
        }
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        if (letters[left] > target || letters[right] <= target) return letters[left];

        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (letters[mid] <= target) left = mid + 1;
            else if (letters[mid] > target) right = mid - 1;
        }

        return letters[left];
    }
}
