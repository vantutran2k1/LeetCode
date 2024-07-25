package ContainerWithMostWater11;

import java.util.List;

public class Solution {
    private record TestCase(int[] height, int expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                new Solution.TestCase(new int[]{1, 1}, 1),
                new Solution.TestCase(new int[]{1, 2}, 1)
        );

        for (TestCase testCase : testCases) {
            System.out.println(maxArea(testCase.height) == (testCase.expectedResult));
        }
    }

    public static int maxArea(int[] height) {
        int maxArea = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
        int i = 0, j = height.length - 1;
        while (j - i >= 1) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);

            if (height[i] <= height[j])
                i++;
            else
                j--;
        }

        return maxArea;
    }
}
