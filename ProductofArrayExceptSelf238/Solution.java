package ProductofArrayExceptSelf238;

import java.util.Arrays;
import java.util.List;

public class Solution {
    private record TestCase(int[] nums, int[] expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                new Solution.TestCase(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );

        for (TestCase testCase : testCases) {
            System.out.println(Arrays.equals(productExceptSelf(testCase.nums), testCase.expectedResult));
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++)
            result[i] = nums[i - 1] * result[i - 1];

        int current = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            current *= nums[i + 1];
            result[i] *= current;
        }

        return result;
    }
}
