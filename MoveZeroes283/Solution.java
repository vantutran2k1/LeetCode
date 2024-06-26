package MoveZeroes283;

import java.util.Arrays;
import java.util.List;

public class Solution {
    private record TestCase(int[] nums, int[] expectedResult) {
    }

    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new Solution.TestCase(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                new Solution.TestCase(new int[]{0}, new int[]{0})
        );

        for (TestCase testCase : testCases) {
            moveZeroes(testCase.nums);
            System.out.println(Arrays.equals(testCase.nums, testCase.expectedResult));
        }
    }

    public static void moveZeroes(int[] nums) {
        int[] numZeros = new int[nums.length];

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                numZeros[i] = count;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, i - numZeros[i]);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
