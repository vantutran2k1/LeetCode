package CanMakeArithmeticProgressionFromSequence1502;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private record TestCase(int[] arr, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{3, 5, 1}, true),
                new Solution.TestCase(new int[]{1, 2, 4}, false),
                new Solution.TestCase(new int[]{0, 0, 0, 0}, true)
        );

        for (TestCase testCase : testCases) {
            System.out.println(canMakeArithmeticProgression(testCase.arr) == (testCase.expectedResult));
        }
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2)
            return true;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        if ((max - min) % (arr.length - 1) != 0) return false;

        int commonDifference = (max - min) / (arr.length - 1);

        if (commonDifference == 0) {
            for (int value : arr) {
                if (value != min) return false;
            }
            return true;
        }

        Set<Integer> distinctValues = new HashSet<>();
        for (int value : arr) {
            distinctValues.add(value);
        }

        for (int value = min; value <= max; value += commonDifference) {
            if (!distinctValues.contains(value)) return false;
        }

        return true;
    }
}
