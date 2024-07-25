package CanPlaceFlowers605;

import java.util.List;

public class Solution {
    private record TestCase(int[] flowerbed, int n, boolean expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 0, 0, 0, 1}, 1, true),
                new Solution.TestCase(new int[]{1, 0, 0, 0, 1}, 2, false),
                new Solution.TestCase(new int[]{1, 0, 0, 0, 0, 1}, 2, false),
                new Solution.TestCase(new int[]{1, 0, 0, 0, 1, 0, 0}, 2, true)
        );

        for (TestCase testCase : testCases) {
            System.out.println(canPlaceFlowers(testCase.flowerbed, testCase.n) == (testCase.expectedResult));
        }
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (flowerbed[i] == 0 && isValidLeft(flowerbed, i) && isValidRight(flowerbed, i)) {
                count++;
                i += 2;
            } else
                i += 1;
        }

        return count >= n;
    }

    private static boolean isValidLeft(int[] flowerbed, int i) {
        return i == 0 || flowerbed[i - 1] == 0;
    }

    private static boolean isValidRight(int[] flowerbed, int i) {
        return i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
    }
}
