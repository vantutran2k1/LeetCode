package KidsWiththeGreatestNumberofCandies1431;

import utils.CollectionComparator;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private record TestCase(int[] candies, int extraCandies, List<Boolean> expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
                new Solution.TestCase(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
                new Solution.TestCase(new int[]{12, 1, 12}, 10, List.of(true, false, true))
        );

        for (TestCase testCase : testCases) {
            System.out.println(CollectionComparator.equals(kidsWithCandies(testCase.candies, testCase.extraCandies), testCase.expectedResult));
        }
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = getMax(candies);
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max)
                result.add(true);
            else
                result.add(false);
        }

        return result;
    }

    private static int getMax(int[] candies) {
        int max = candies[0];
        for (int candy : candies) {
            if (candy > max)
                max = candy;
        }

        return max;
    }
}
